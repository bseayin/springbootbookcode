package com.zz.product.serviceImpl;

import com.zz.product.entity.TestData;
import com.zz.product.mapper.TestDataMapper;
import com.zz.product.service.TestDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务数据表 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Service
public class TestDataServiceImpl extends ServiceImpl<TestDataMapper, TestData> implements TestDataService {

}
