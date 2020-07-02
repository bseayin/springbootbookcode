package com.zz.product.serviceImpl;

import com.zz.product.entity.SysUser;
import com.zz.product.mapper.SysUserMapper;
import com.zz.product.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
