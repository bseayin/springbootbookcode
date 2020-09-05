package com.xsz.product.service;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.IService;
import com.xsz.product.domain.Category;
import com.xsz.product.dto.CategoryDTO;

import java.text.ParseException;
import java.util.List;

/**
 * @author llf
 * @description: 菜品父类服务类
 * @date 2020/5/25
 */
public interface CategoryService extends IService<Category> {
    /**
     * 查找所有一级菜单 并分页
     * @param queryRequest
     * @param categoryDTO
     * @return
     */
    List<CategoryDTO> getCategoryListPage(QueryRequest queryRequest, CategoryDTO categoryDTO);

    /**
     * 查找所有一级菜单
     * @param categoryDTO
     * @return
     */
    List<CategoryDTO> getCategoryList(CategoryDTO categoryDTO);

    /**
     * 根据菜品id查询一级菜单
     * @param dishesId
     * @return
     */
    List<CategoryDTO> findCategoryListByDishes(Long dishesId);

    /**
     * 查看单个父类信息
     * @param categoryId
     * @return
     */
    Category getCategory(Long categoryId);


    /**
     * 创建一级菜品分类
     * @param categoryDTO
     */
    void addCategory(CategoryDTO categoryDTO);

    /**
     * 修改一级菜品分类
     * @param categoryDTO
     */
    void updateCategory(CategoryDTO categoryDTO);

    /**
     * 删除一级菜单分类（如果有子菜品则不能删除）
     * @param categoryId
     * @return
     */
    int deleteCategory(Long categoryId);
}
