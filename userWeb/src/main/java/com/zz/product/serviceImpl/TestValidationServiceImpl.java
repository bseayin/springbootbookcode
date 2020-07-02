package com.zz.product.serviceImpl;

import com.zz.product.entity.TestValidation;
import com.zz.product.mapper.TestValidationMapper;
import com.zz.product.service.TestValidationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 校验测试表单 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Service
public class TestValidationServiceImpl extends ServiceImpl<TestValidationMapper, TestValidation> implements TestValidationService {

}
