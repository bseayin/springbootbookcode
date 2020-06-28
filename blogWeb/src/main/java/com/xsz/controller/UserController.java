package com.xsz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsz.entity.User;
import com.xsz.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Bsea
 * 	用户管理模块 用户控制类
 */
@RequestMapping("user")
@RestController
@Api(value = "用户API")
public class UserController {
	@Resource
	UserService userService;
	//注册
	@ApiOperation(value = "注册")
	@PostMapping("save")
	public User register(@RequestBody User user) {
		return userService.add(user);
	}
	
	//登录
	@ApiOperation(value = "登录")
	@PostMapping("login")
	public User login(@RequestBody User user) {
		return userService.login(user.getName(), user.getPwd());
	}
	//修改用户
	@ApiOperation(value = "修改用户", notes = "修改用户")
	@PostMapping("modify")
	public User update(@RequestBody User user) {
		return userService.update(user);
	}
	//删除用户
	@ApiOperation(value = "删除用户", notes = "删除用户")
	@ApiImplicitParam(name = "id", value = "用户的主键Id", required = true, dataType = "String", paramType = "path")
	@PostMapping("delete/{id}")
	public Map<String, String> delete(@PathVariable("id") String id) {
		Map<String, String> result=new HashMap();
		userService.delete(id);
		result.put("result", "success");
		return result;
	}
	
	

    //查询用户
	@ApiOperation(value = "查询所有用户", notes = "查询所有用户")
	@GetMapping("showAll")
	public List<User> selectAll() {
		return userService.getAll();
	}
	
	    //根据user id查询用户
		@ApiOperation(value = "根据用户的主键查询用户", notes = "根据user id查询用户")
		@GetMapping("showByBlog/{bid}")
		@ApiImplicitParam(name = "bid", value = "用户的主键Id", required = true, dataType = "String", paramType = "path")
		public User selectByBlog(@PathVariable("bid") String userId) {
			return userService.selectById(userId);
		}
	

}
