package com.zz.product.serviceImpl;

import com.zz.product.entity.GroupUser;
import com.zz.product.mapper.GroupUserMapper;
import com.zz.product.service.GroupUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 群组成员 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Service
public class GroupUserServiceImpl extends ServiceImpl<GroupUserMapper, GroupUser> implements GroupUserService {

}
