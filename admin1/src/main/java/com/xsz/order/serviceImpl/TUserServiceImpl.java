package com.xsz.order.serviceImpl;

import com.xsz.order.entity.TUser;
import com.xsz.order.mapper.TUserMapper;
import com.xsz.order.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-09-05
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
