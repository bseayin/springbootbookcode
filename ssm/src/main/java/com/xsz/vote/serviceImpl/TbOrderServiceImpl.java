package com.xsz.vote.serviceImpl;

import com.xsz.vote.entity.TbOrder;
import com.xsz.vote.mapper.TbOrderMapper;
import com.xsz.vote.service.TbOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Service
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder> implements TbOrderService {

}
