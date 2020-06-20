package com.xsz.vote.serviceImpl;

import com.xsz.vote.entity.TUser;
import com.xsz.vote.mapper.TUserMapper;
import com.xsz.vote.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
