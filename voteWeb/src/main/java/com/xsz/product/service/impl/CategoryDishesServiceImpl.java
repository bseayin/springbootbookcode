package com.xsz.product.service.impl;


import com.xsz.common.service.impl.BaseService;
import com.xsz.product.domain.CategoryDishes;
import com.xsz.product.service.CategoryDishesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


/**
 * @author llf
 * @description: 菜品父类和菜品的中间表 服务实现类
 * @date 2020/5/25
 */
@Service("CategoryDishesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CategoryDishesServiceImpl extends BaseService<CategoryDishes> implements CategoryDishesService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCategoryDishesByCategoryId(String categoryId) {
        List<String> list = Arrays.asList(categoryId.split(","));
        batchDelete(list,"categoryId",CategoryDishes.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCategoryDishesByDishesId(String dishesId) {
        List<String> list = Arrays.asList(dishesId.split(","));
        batchDelete(list,"spareId",CategoryDishes.class);
    }
}
