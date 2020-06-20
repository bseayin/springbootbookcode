package com.xsz.vote.serviceImpl;

import com.xsz.vote.entity.TbCategory;
import com.xsz.vote.mapper.TbCategoryMapper;
import com.xsz.vote.service.TbCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品父类分类表 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Service
public class TbCategoryServiceImpl extends ServiceImpl<TbCategoryMapper, TbCategory> implements TbCategoryService {

}
