package com.zz.user.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.user.entity.SysPermissions;
import com.zz.user.entity.SysRolesPermissions;
import com.zz.user.mapper.SysPermissionsMapper;
import com.zz.user.service.SysPermissionsService;
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
public class SysPermissionsServiceImpl extends ServiceImpl<SysPermissionsMapper, SysPermissions> implements SysPermissionsService {
    @Resource
    SysPermissionsMapper sysPermissionsMapper;

    /**
     * 分页查询
     * @param page
     * @return
     */
    public IPage<SysPermissions> findByPage(Page<SysPermissions> page){

        return   sysPermissionsMapper.selectPage(page, null);

    }
}
