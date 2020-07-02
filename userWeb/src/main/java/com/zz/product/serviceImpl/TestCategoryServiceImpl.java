package com.zz.product.serviceImpl;

import com.zz.product.entity.TestCategory;
import com.zz.product.mapper.TestCategoryMapper;
import com.zz.product.service.TestCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类型 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Service
public class TestCategoryServiceImpl extends ServiceImpl<TestCategoryMapper, TestCategory> implements TestCategoryService {

}
