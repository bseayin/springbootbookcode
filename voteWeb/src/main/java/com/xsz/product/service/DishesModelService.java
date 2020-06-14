package com.xsz.product.service;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.IService;
import com.xsz.product.domain.Dishes;
import com.xsz.product.domain.DishesModel;
import com.xsz.product.dto.DishesDTO;

import java.util.List;

/**
 * @author llf
 * @description: 菜品规格服务类
 * @date 2020/6/1
 */
public interface DishesModelService extends IService<DishesModel> {


    /**
     * 根据菜品id查询菜品规格信息（分页）
     * @param request
     * @param dishesId
     * @return
     */
    List<DishesModel> getDishesModelPage(QueryRequest request, Long dishesId);


    /**
     * 删除菜品规格信息
     * @param modelId 菜品规格id
     */
    void deleteDishesModel(Long modelId);

    /**
     * 新建/修改菜品规格信息
     * @param dishesModelList
     * @param dishesId
     * @param isAdd 是否是新建
     */
    void addOrUpdateDishesModel(List<DishesModel> dishesModelList,Long dishesId,Boolean isAdd);


}
