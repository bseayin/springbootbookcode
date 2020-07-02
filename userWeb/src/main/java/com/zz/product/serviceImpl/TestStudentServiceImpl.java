package com.zz.product.serviceImpl;

import com.zz.product.entity.TestStudent;
import com.zz.product.mapper.TestStudentMapper;
import com.zz.product.service.TestStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Service
public class TestStudentServiceImpl extends ServiceImpl<TestStudentMapper, TestStudent> implements TestStudentService {

}
