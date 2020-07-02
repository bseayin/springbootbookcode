package com.zz.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.user.entity.SysPermissions;
import com.zz.user.entity.SysRoles;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bsea
 * @since 2019-12-25
 */
public interface SysRolesService extends IService<SysRoles> {
    public IPage<SysRoles> findByPage(Page<SysRoles> page);
}
