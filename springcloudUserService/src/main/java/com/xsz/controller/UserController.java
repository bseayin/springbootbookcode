package com.xsz.controller;

import com.xsz.entity.User;
import com.xsz.service.UserService;
import com.xsz.util.MD5Utils;
import com.xsz.util.ResultVOUtil;
import com.xsz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "用户控制类")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation(value = "登录API")
    @PostMapping("/login")
    public ResultVO selectByNamePwd(@RequestBody User user) {
        System.out.println("进入认证");
        System.out.println("username***" + user.getUname());
        System.out.println("password***" + user.getPwd());
        String password = user.getPwd();
        String username = user.getUname();
        password = MD5Utils.encrypt(username, password);
        System.out.println("encryptpassword***" + password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User loginuser = (User) SecurityUtils.getSubject().getPrincipal();
            return ResultVOUtil.success(loginuser);
        } catch (UnknownAccountException e) {
            return ResultVOUtil.error(500, "账号不存在");
        } catch (IncorrectCredentialsException e) {
            return ResultVOUtil.error(500, "密码错误");
        } catch (LockedAccountException e) {
            return ResultVOUtil.error(500, "账号被锁定");
        } catch (AuthenticationException e) {
            return ResultVOUtil.error(500, "登录失败");
        }
    }

    /**
     * 查询当前用户信息
     **/
    @ApiOperation(value = "用户信息")
    @GetMapping("/info")
    public ResultVO showUserInfo(@RequestParam("id") String id) {
//        User loginuser = (User) SecurityUtils.getSubject().getPrincipal();

        User userInfo = userService.selectById(id);

        return ResultVOUtil.success(userInfo);
    }


    /**
     * 修改当前用户信息
     **/
    @ApiOperation(value = "修改用户信息")
    @PostMapping("/infoEdit")
    public ResultVO UserInfoEdit(@RequestBody User user) {
        if (userService.update(user) == 1) {
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(500, "修改失败");
        }
    }

    /**
     * 注册
     * 注意： 数据库保存的密码是 MD5加密以后的密文
     *
     * @param user
     * @return
     */
    @ApiOperation("注册")
    @PostMapping("/register")
    public ResultVO add(@RequestBody User user) {
        if (userService.getByUname(user.getUname()) != null) {
            return ResultVOUtil.error(500, "用户名已存在");
        } else {
            String password = MD5Utils.encrypt(user.getUname(), user.getPwd());
            System.out.println("注册加密密码：" + password);
            user.setPwd(password);
            return ResultVOUtil.success(userService.add(user));
        }

    }

    /**
     * 验证当前用户原始密码
     **/
    @ApiOperation(value = "验证原始密码")
    @PostMapping("/confirmOldPwd")
    public ResultVO confirmOldPwd(@RequestBody User user) {
        String password = MD5Utils.encrypt(user.getUname(), user.getPwd());
        String oldPassword = userService.selectById(user.getId()).getPwd();

        if (password.equals(oldPassword)) {
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(500, "原始密码错误");
        }
    }


    /**
     * 修改当前用户原始密码
     **/
    @ApiOperation(value = "修改密码")
    @PostMapping("/modifyPwd")
    public ResultVO modifyPwd(@RequestBody User user) {
        String password = MD5Utils.encrypt(user.getUname(), user.getPwd());
        user.setPwd(password);
        if (userService.updatePwd(user) == 1) {
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(500, "修改失败");
        }

    }

    /**修改用户头像**/
    @ApiOperation(value = "修改用户头像")
    @PostMapping("/modifyImage/{imagePath}/{id}")
    public void modifyImage(@PathVariable("imagePath") String imagePath, @PathVariable("id") String id) throws IOException {

        int result = userService.modifyImagePath("images/" + id + "-" + imagePath, id);
    }

    /**企业申请**/
    @ApiOperation(value = "企业申请")
    @GetMapping("/application/{id}/{applicationPath}")
    public ResultVO modifyApplicationStatus(@PathVariable("id") String id, @PathVariable("applicationPath") String applicationPath) throws IOException {

        if (userService.modifyApplicationStatus(id, "/job/application/" + id + "-" + applicationPath) == 1) {
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(500, "申请失败");
        }
    }

    /**修改用户角色**/
    @ApiOperation(value = "修改用户角色")
    @GetMapping("/modifyRole/{id}")
//    @RequiresPermissions("userInfo:modifyRole")//权限管理;
    public ResultVO modifyRole(@PathVariable("id") String id) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isPermitted("userInfo:modifyRole")){
            System.out.println("adgasdf");
        }
        boolean b = subject.hasRole("管理员");
        subject.checkPermission("userInfo:modifyRole");

        if (userService.modifyRole(id) == 1) {
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(500, "申请失败");
        }
    }

    /**查询所有企业申请**/
    @ApiOperation(value = "查询所有企业申请")
    @GetMapping("showAllApplication")
    public ResultVO showAllApplication(){
        return ResultVOUtil.success( userService.showAllApplication());
    }

}
