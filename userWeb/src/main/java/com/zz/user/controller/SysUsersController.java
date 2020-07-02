package com.zz.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.user.entity.SysRoles;
import com.zz.user.entity.SysUsers;
import com.zz.user.service.SysUsersService;
import com.zz.util.KeyUtil;
import com.zz.util.MD5Utils;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bsea
 * @since 2019-12-25
 */
@Api(value = "用户Controller")
@Controller
@RequestMapping("user")
public class SysUsersController {

    @Resource
    SysUsersService userService;

    @GetMapping("/register")
    public String login() {
        return "sign-up.html";
    }

    @ApiOperation(value = "注册", notes = "注册")
    @ApiImplicitParam(name = "SysUsers", value = "用户实体", required = true, dataType = "SysUsers")
    @PostMapping("/register")
    @ResponseBody
    public ResultVO register(SysUsers user) {

        String password = MD5Utils.encrypt(user.getUsername(), user.getPassword());
        user.setPassword(password);
        user.setId(KeyUtil.genUniqueKeyLong());
        userService.save(user);
        return ResultVOUtil.success();
    }

    @PostMapping("/getlogin")
    @ResponseBody
    public SysUsers getLoginUser(){
        return (SysUsers) SecurityUtils.getSubject().getPrincipal();
    }

    @ApiOperation(value = "分页获取用户列表", notes = "获取用户列表")
    @GetMapping("/list/{pageNo}/{pageSize}")
    @ResponseBody
    public ResultVO listData(@PathVariable("pageNo") String pageNo , @PathVariable("pageSize") String pageSize) {
        Page<SysUsers> page=new Page<SysUsers>(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        return ResultVOUtil.success( userService.findByPage(page));
    }

}

