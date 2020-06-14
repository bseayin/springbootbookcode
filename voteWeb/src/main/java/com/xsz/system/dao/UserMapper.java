package com.xsz.system.dao;

import com.xsz.common.config.MyMapper;
import com.xsz.system.domain.User;
import com.xsz.system.domain.UserWithRole;

import java.util.List;



public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}