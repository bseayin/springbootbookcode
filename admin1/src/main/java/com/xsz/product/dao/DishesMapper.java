package com.xsz.product.dao;

import com.xsz.common.config.MyMapper;
import com.xsz.product.domain.Dishes;
import com.xsz.product.dto.DishesDTO;

import java.util.List;

/**
 * @author llf
 * @description: 菜品Mapper类
 * @date 2020/5/25
 */
public interface DishesMapper extends MyMapper<Dishes> {

    /**
     * 根据不同的检索信息查询（分页）
     * @param dishesDTO
     * @return
     */
    List<DishesDTO> findDishesPage(DishesDTO dishesDTO);

    /**
     * 插入菜品并返回主键
     * @return
     */
    Long addDishesReturnKey(Dishes dishes);
}