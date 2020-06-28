package com.xsz.repository;

import com.xsz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository<User,String>  第一个参数是实体类，第二个参数是实体类的主键数据类型
public interface UserRepository extends JpaRepository<User,String> {
	
	public User findByNameAndPwd(String name, String pwd);
	public List<User> findByNameLike(String name);
	public User findByName(String name);

}
