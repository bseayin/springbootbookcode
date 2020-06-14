package com.xsz.product.dao;

import com.xsz.common.config.MyMapper;
import com.xsz.product.domain.CategoryDishes;

import java.util.List;

/**
 * @author llf
 * @description: 菜品父类和菜品中间表Mapper类
 * @date 2020/5/25
 */
public interface CategoryDishesMapper extends MyMapper<CategoryDishes> {
    /**
     *通过一级菜单id查询，此分类下所有菜品idList
     * @param categoryId
     * @return
     */
    List<String> getDishesIdByCategory(Long categoryId);
}