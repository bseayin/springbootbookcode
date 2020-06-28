package com.xsz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xsz.entity.User;

//JpaRepository<User,String>  第一个参数是实体类，第二个参数是实体类的主键数据类型
public interface UserRepository extends JpaRepository<User,String> {
	
	public User findByNameAndPwd(String name,String pwd);
	public List<User> findByNameLike(String name);

}
