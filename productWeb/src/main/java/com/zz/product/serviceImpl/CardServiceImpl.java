package com.zz.product.serviceImpl;

import com.zz.product.entity.Card;
import com.zz.product.mapper.CardMapper;
import com.zz.product.service.CardService;
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
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {

}
