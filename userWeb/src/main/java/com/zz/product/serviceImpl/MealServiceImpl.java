package com.zz.product.serviceImpl;

import com.zz.product.entity.Meal;
import com.zz.product.mapper.MealMapper;
import com.zz.product.service.MealService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements MealService {

}
