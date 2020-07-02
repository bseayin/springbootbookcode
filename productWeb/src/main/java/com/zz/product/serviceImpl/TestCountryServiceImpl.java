package com.zz.product.serviceImpl;

import com.zz.product.entity.TestCountry;
import com.zz.product.mapper.TestCountryMapper;
import com.zz.product.service.TestCountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 国家 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Service
public class TestCountryServiceImpl extends ServiceImpl<TestCountryMapper, TestCountry> implements TestCountryService {

}
