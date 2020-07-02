package com.zz.product.serviceImpl;

import com.zz.product.entity.TestCar;
import com.zz.product.mapper.TestCarMapper;
import com.zz.product.service.TestCarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Service
public class TestCarServiceImpl extends ServiceImpl<TestCarMapper, TestCar> implements TestCarService {

}
