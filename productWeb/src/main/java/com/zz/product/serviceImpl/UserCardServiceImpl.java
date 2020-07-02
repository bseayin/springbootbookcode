package com.zz.product.serviceImpl;

import com.zz.product.entity.UserCard;
import com.zz.product.mapper.UserCardMapper;
import com.zz.product.service.UserCardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Service
public class UserCardServiceImpl extends ServiceImpl<UserCardMapper, UserCard> implements UserCardService {

}
