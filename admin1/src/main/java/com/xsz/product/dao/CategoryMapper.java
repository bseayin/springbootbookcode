package com.xsz.product.dao;

import com.xsz.common.config.MyMapper;
import com.xsz.product.domain.Category;
import com.xsz.product.dto.CategoryDTO;

import java.util.List;

/**
 * @author llf
 * @description: 菜品父类Mapper类
 * @date 2020/5/25
 */
public interface CategoryMapper extends MyMapper<Category> {

    /**
     * 根据店铺id查找一级菜单
     *
     * @param deptId 部门id（商铺id）
     * @return
     */
    List<Category> getCategoryByCompanyId(Long deptId);

    /**
     * 查询一级菜单并分页
     *
     * @param categoryDTO
     * @return
     */
    List<CategoryDTO> findCategoryList(CategoryDTO categoryDTO);

    /**
     * 根据菜品id返回父类分类
     * @param dishesId
     * @return
     */
    List<CategoryDTO> findCategoryListByDishes(Long dishesId);
}