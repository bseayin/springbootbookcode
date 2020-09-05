package com.xsz.product.service;

import com.xsz.common.service.IService;
import com.xsz.product.domain.CategoryDishes;

/**
 * @author llf
 * @description: 菜品父类和菜品的中间表 服务类
 * @date 2020/5/25
 */
public interface CategoryDishesService extends IService<CategoryDishes> {

    /**
     * 根据菜品分类id删除中间表信息
     * @param categoryId
     */
    void deleteCategoryDishesByCategoryId(String categoryId);

    /**
     * 根据菜品id删除中间表信息
     * @param dishesId
     */
    void deleteCategoryDishesByDishesId(String dishesId);
}
