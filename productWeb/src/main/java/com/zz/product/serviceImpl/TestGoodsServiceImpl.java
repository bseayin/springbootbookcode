package com.zz.product.serviceImpl;

import com.zz.product.entity.TestGoods;
import com.zz.product.mapper.TestGoodsMapper;
import com.zz.product.service.TestGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Service
public class TestGoodsServiceImpl extends ServiceImpl<TestGoodsMapper, TestGoods> implements TestGoodsService {

}
