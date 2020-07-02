package com.zz.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.user.entity.SysRoles;
import com.zz.user.entity.SysUsers;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bsea
 * @since 2019-12-25
 */
public interface SysUsersService extends IService<SysUsers> {
    public IPage<SysUsers> findByPage(Page<SysUsers> page);

}
