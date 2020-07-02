package com.xsz.repository;

import com.xsz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

//JpaRepository<User,String>  第一个参数是实体类，第二个参数是实体类的主键数据类型
public interface UserRepository extends JpaRepository<User,String> {
	
	public User findByNameAndPwd(String name, String pwd);
	public List<User> findByNameLike(String name);
	public User findByUname(String uname);

	@Modifying
	@Transactional
	@Query("update User set name=?1, sex=?2, mobile=?3, age=?5, email=?6 where id=?4")
	int userEdit(String name, String sex, String mobile, String id, Integer age, String email);

	@Modifying
	@Transactional
	@Query("update User set pwd=?1 where id=?2")
	int udpatePwd(String pwd, String id);

	@Modifying
	@Transactional
	@Query("update User set imagePath=?1 where id=?2")
    int modifyImagePath(String imagePath, String id);

	@Modifying
	@Transactional
	@Query("update User set applicationStatus=1, applicationPath=?2 where id=?1")
    int modifyApplicationStatus(String id, String applicationPath);

    List<User> findByapplicationStatus(Byte applicationStatus);
}
