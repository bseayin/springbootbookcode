package com.xsz.system.service;

import com.xsz.common.service.IService;
import com.xsz.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
