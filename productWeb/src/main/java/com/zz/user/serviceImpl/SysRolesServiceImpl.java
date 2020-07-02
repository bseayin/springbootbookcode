package com.zz.user.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.user.entity.SysPermissions;
import com.zz.user.entity.SysRoles;
import com.zz.user.mapper.SysPermissionsMapper;
import com.zz.user.mapper.SysRolesMapper;
import com.zz.user.service.SysRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2019-12-25
 */
@Service
public class SysRolesServiceImpl extends ServiceImpl<SysRolesMapper, SysRoles> implements SysRolesService {
    @Resource
    SysRolesMapper sysRolesMapper;

    @Override
    public IPage<SysRoles> findByPage(Page<SysRoles> page) {
        return   sysRolesMapper.selectPage(page, null);
    }
}
