package com.xsz.order.serviceImpl;

import com.xsz.order.entity.TbCategory;
import com.xsz.order.mapper.TbCategoryMapper;
import com.xsz.order.service.TbCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品父类分类表 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-09-05
 */
@Service
public class TbCategoryServiceImpl extends ServiceImpl<TbCategoryMapper, TbCategory> implements TbCategoryService {

}
