package com.xsz.service;

import com.xsz.entity.User;
import com.xsz.repository.UserRepository;
import com.xsz.util.KeyUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class   UserService {
	@Resource
	UserRepository userRepository;

	//新建
	public User add(User user) {
		user.setId(KeyUtil.getId());
		return userRepository.save(user);
	}
	
	//修改

	public User update(User user) {
		return userRepository.save(user);
	}
	
	
	//删除

	public void delete(String id) {
		 userRepository.deleteById(id);
	}
	
	//查询

	public User selectById(String id) {
		 return userRepository.findById(id).get();
	}
	

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User login(String name,String pwd) {
		User user=userRepository.findByNameAndPwd(name, pwd);

		return user;
	}

	public List<User> likeName(String name) {
		return userRepository.findByNameLike(name+"%");
	}

	public User getByName(String name) {
		return userRepository.findByName(name);
	}

}
