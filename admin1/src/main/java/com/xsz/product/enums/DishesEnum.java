package com.xsz.product.enums;

import com.xsz.common.enums.IEnum;

/**
 * @author llf
 * @description: 菜品状态枚举类
 * @date 2020/5/26
 */
public enum DishesEnum implements IEnum<DishesEnum,Integer> {
    /**
     * 已上架
     */
    SHELVES(0),
    /**
     * 已下架
     */
    UNSHELVES(1),
    /**
     * 已售罄
     */
    SELLOUT(2);

    private int value;

    DishesEnum(int value){
        this.value=value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
