package com.xsz.product.domain;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 * @author llf
 * @description: 菜品规格表entity类
 * @date 2020/6/1
 */
@Table(name = "tb_dishes_model")
public class DishesModel {
    /**
     * 主键编号
     */
    @Id
    @Column(name = "model_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelId;

    /**
     * 商品编号
     */
    @Column(name = "dishes_id")
    private Long dishesId;

    /**
     * 商品规格
     */
    @Column(name = "dishes_model")
    private String dishesModel;

    /**
     * 商品规格（英文）
     */
    @Column(name = "dishes_model_en")
    private String dishesModelEn;

    /**
     * 单价
     */
    @Column(name = "dishes_price")
    private BigDecimal dishesPrice;

    /**
     * 获取主键编号
     *
     * @return model_id - 主键编号
     */
    public Long getModelId() {
        return modelId;
    }

    /**
     * 设置主键编号
     *
     * @param modelId 主键编号
     */
    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    /**
     * 获取商品编号
     *
     * @return dishes_id - 商品编号
     */
    public Long getDishesId() {
        return dishesId;
    }

    /**
     * 设置商品编号
     *
     * @param dishesId 商品编号
     */
    public void setDishesId(Long dishesId) {
        this.dishesId = dishesId;
    }

    /**
     * 获取商品规格
     *
     * @return dishes_model - 商品规格
     */
    public String getDishesModel() {
        return dishesModel;
    }

    /**
     * 设置商品规格
     *
     * @param dishesModel 商品规格
     */
    public void setDishesModel(String dishesModel) {
        this.dishesModel = dishesModel == null ? null : dishesModel.trim();
    }

    /**
     * 获取商品规格（英文）
     *
     * @return dishes_model_en - 商品规格（英文）
     */
    public String getDishesModelEn() {
        return dishesModelEn;
    }

    /**
     * 设置商品规格（英文）
     *
     * @param dishesModelEn 商品规格（英文）
     */
    public void setDishesModelEn(String dishesModelEn) {
        this.dishesModelEn = dishesModelEn == null ? null : dishesModelEn.trim();
    }

    /**
     * 获取单价
     *
     * @return dishes_price - 单价
     */
    public BigDecimal getDishesPrice() {
        return dishesPrice;
    }

    /**
     * 设置单价
     *
     * @param dishesPrice 单价
     */
    public void setDishesPrice(BigDecimal dishesPrice) {
        this.dishesPrice = dishesPrice;
    }
}