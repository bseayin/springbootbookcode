package com.xsz.product.service;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.IService;
import com.xsz.product.domain.Dishes;
import com.xsz.product.dto.DishesDTO;

import java.util.List;

/**
 * @author llf
 * @description: 菜品服务类
 * @date 2020/5/25
 */
public interface DishesService extends IService<Dishes> {

    /**
     * 根据菜品id查询菜品所有信息
     * @param id
     * @return
     */
    Dishes getDishesById(Long id);


    /**
     * 根据不同的检索信息查询（分页）
     * @param request
     * @param dishesDTO
     * @return
     */
    List<DishesDTO> getDishesPage(QueryRequest request, DishesDTO dishesDTO);

    /**
     * 通过一级菜单查找商品
     * @param categoryId
     * @return
     */
    List<DishesDTO> getDishesByCategoryId(Long categoryId);


    /**
     * 根据菜品id下架菜品信息
     * @param ids 菜品id
     * @param userId 用户id
     */
    void deleteDishes(String ids,Long userId);

    /**
     * 新建菜品 并返回id
     * @param dishesDTO
     * @param categoryIds
     * @return
     */
    Long addDishes(DishesDTO dishesDTO,Long[] categoryIds);

    /**
     * 更新菜品
     * @param dishesDTO
     * @param categoryIds
     */
    void updateDishes(DishesDTO dishesDTO,Long[] categoryIds);

    /**
     * 更新上传图片
     * @param dishesDTO
     */
     void updateDishesFile(DishesDTO dishesDTO);
}
