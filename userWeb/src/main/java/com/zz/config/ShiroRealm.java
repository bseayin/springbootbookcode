package com.zz.config;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.user.entity.SysUsers;
import com.zz.user.serviceImpl.SysUsersServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;



//import com.springboot.dao.UserMapper;
//import com.springboot.pojo.User;

public class ShiroRealm extends AuthorizingRealm {

	@Resource
	private SysUsersServiceImpl sysUsersServiceImpl;

	/**
	 * 获取用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());

		System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
//		User user = userMapper.findByUserName(userName);
		QueryWrapper<SysUsers> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", userName);
		SysUsers user = sysUsersServiceImpl.getOne(queryWrapper);
//		User user=new User();
		if (user == null) {
			throw new UnknownAccountException("用户名错误！");
		}
		//1. MD5加密不可以破解
		//2. 登录比较的是，两个密文
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("密码错误！");
		}
		if (user.getLocked()) {
			throw new LockedAccountException("账号已被锁定,请联系管理员！");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}