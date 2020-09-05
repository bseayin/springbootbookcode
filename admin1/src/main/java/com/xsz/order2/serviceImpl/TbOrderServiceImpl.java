package com.xsz.order2.serviceImpl;

import com.xsz.order2.entity.TbOrder;
import com.xsz.order2.mapper.TbOrderMapper;
import com.xsz.order2.service.TbOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-09-05
 */
@Service
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder> implements TbOrderService {

}
