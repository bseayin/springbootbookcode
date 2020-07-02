package com.zz.user.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.user.entity.SysUsers;
import com.zz.user.entity.SysUsers;
import com.zz.user.mapper.SysUsersMapper;
import com.zz.user.mapper.SysUsersMapper;
import com.zz.user.service.SysUsersService;
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
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements SysUsersService {


    @Resource
    SysUsersMapper sysUsersMapper;

    @Override
    public IPage<SysUsers> findByPage(Page<SysUsers> page) {
        return   sysUsersMapper.selectPage(page, null);
    }
    
}
