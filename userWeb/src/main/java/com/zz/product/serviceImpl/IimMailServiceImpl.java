package com.zz.product.serviceImpl;

import com.zz.product.entity.IimMail;
import com.zz.product.mapper.IimMailMapper;
import com.zz.product.service.IimMailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 邮件 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Service
public class IimMailServiceImpl extends ServiceImpl<IimMailMapper, IimMail> implements IimMailService {

}
