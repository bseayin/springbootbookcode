package com.xsz.service;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xsz.entity.User;
import com.xsz.repository.UserRepository;
import com.xsz.util.KeyUtil;

@Service
@CacheConfig(cacheNames = "UserService")
public class UserService {
	@Resource
	UserRepository userRepository;
	@Resource 
	RedisTemplateService redisTemplateService;
	//新建
	public User add(User user) {
		user.setId(KeyUtil.getId());
		return userRepository.save(user);
	}
	
	//修改
	@CachePut(key = "#p0.id")
	public User update(User user) {
		return userRepository.save(user);
	}
	
	
	//删除
	@CacheEvict(key = "#p0")
	public void delete(String id) {
		 userRepository.deleteById(id);
	}
	
	//查询
	@Cacheable(key = "#p0")
	public User selectById(String id) {
		 return userRepository.findById(id).get();
	}
	
	@Cacheable
	public List<User> getAll() {
		return userRepository.findAll();
	}
	@Cacheable
	public User login(String name,String pwd) {
		User user=userRepository.findByNameAndPwd(name, pwd);
		redisTemplateService.set("login",user);
		return user;
	}
	@Cacheable
	public List<User> likeName(String name) {
		return userRepository.findByNameLike(name+"%");
	}

}
