package com.zz.product.serviceImpl;

import com.zz.product.entity.OrderDetail;
import com.zz.product.mapper.OrderDetailMapper;
import com.zz.product.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
