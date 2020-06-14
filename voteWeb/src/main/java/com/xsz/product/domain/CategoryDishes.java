package com.xsz.product.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author llf
 * @description: 菜品父类和菜品中间表entity类
 * @date 2020/5/25
 */
@Table(name = "tb_category_dishes")
public class CategoryDishes implements Serializable {
    private static final long serialVersionUID = -4852732617765810959L;
    /**
     * 菜品父类分类id
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 菜品id
     */
    @Column(name = "spare_id")
    private Long spareId;

    /**
     * 获取菜品父类分类id
     *
     * @return category_id - 菜品父类分类id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置菜品父类分类id
     *
     * @param categoryId 菜品父类分类id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取菜品id
     *
     * @return spare_id - 菜品id
     */
    public Long getSpareId() {
        return spareId;
    }

    /**
     * 设置菜品id
     *
     * @param spareId 菜品id
     */
    public void setSpareId(Long spareId) {
        this.spareId = spareId;
    }
}