package com.xsz.service;

import com.xsz.entity.User;
import com.xsz.repository.DTODao;
import com.xsz.repository.UserRepository;
import com.xsz.util.KeyUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Service

public class UserService {
	@Resource
	UserRepository userRepository;
	@Resource
	DTODao dtoDao;

	//新建
	public User add(User user) {
		user.setId(KeyUtil.getId());
		return userRepository.save(user);
	}

	/**查询用户信息**/
	public User selectById(String id) {
		 return userRepository.findById(id).get();
	}
	/**查询用户信息**/
	public User getByUname(String name) {
		return userRepository.findByUname(name);
	}
	/**修改用户信息**/
	public int update (User user){
		String name = user.getName();
		String sex = user.getSex();
		String mobile = user.getMobile();
		Integer age = user.getAge();
		String email = user.getEmail();
		String id = user.getId();

		return userRepository.userEdit(name, sex, mobile, id, age, email);
	}
	/**修改用户登录密码**/
    public int  updatePwd(User user) {
		return userRepository.udpatePwd(user.getPwd(), user.getId());
    }
	/**修改用户头像**/
    public int modifyImagePath(String imagePath, String id) {
		return userRepository.modifyImagePath(imagePath, id);
    }

    public int modifyApplicationStatus(String id, String applicationPath) {
		return userRepository.modifyApplicationStatus(id, applicationPath);
    }

	/**修改用户角色**/
    public int modifyRole(String id) {
		return dtoDao.modifyRole(id);
    }

	public List<User> showAllApplication() {
    	return userRepository.findByapplicationStatus((byte) 1);
	}
}
