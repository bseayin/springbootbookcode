package com.zz.user.controller;

import com.zz.user.entity.SysUsers;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.util.MD5Utils;

@Api(value = "登录Controller")
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login.html";
	}

	@ApiOperation(value = "登录", notes = "登录")
	@PostMapping("/login")
	@ResponseBody
	public ResultVO login(String username, String password, Boolean rememberMe) {
		
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return ResultVOUtil.success();
		} catch (UnknownAccountException e) {
			return ResultVOUtil.error(500,e.getMessage());
		} catch (IncorrectCredentialsException e) {
            return ResultVOUtil.error(500,e.getMessage());
		} catch (LockedAccountException e) {
            return ResultVOUtil.error(500,e.getMessage());
		} catch (AuthenticationException e) {
            return ResultVOUtil.error(500,"认证失败！");
		}
	}

	@RequestMapping("/")
	public String redirectIndex() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index(Model model) {
        SysUsers user = (SysUsers) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user", user);
		return "index.html";
	}
	
	@PostMapping("/getlogin")
	@ResponseBody
	public SysUsers getLoginUser(){
		return (SysUsers) SecurityUtils.getSubject().getPrincipal();
	}
}