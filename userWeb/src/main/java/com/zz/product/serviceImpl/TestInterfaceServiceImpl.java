package com.zz.product.serviceImpl;

import com.zz.product.entity.TestInterface;
import com.zz.product.mapper.TestInterfaceMapper;
import com.zz.product.service.TestInterfaceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 接口列表 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Service
public class TestInterfaceServiceImpl extends ServiceImpl<TestInterfaceMapper, TestInterface> implements TestInterfaceService {

}
