package com.xsz.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品规格表
 * </p>
 *
 * @author Bsea
 * @since 2020-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbDishesModel对象", description="商品规格表")
public class TbDishesModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键编号")
    @TableId(value = "model_id", type = IdType.AUTO)
    private Long modelId;

    @ApiModelProperty(value = "商品编号")
    private Long dishesId;

    @ApiModelProperty(value = "商品规格")
    private String dishesModel;

    @ApiModelProperty(value = "商品规格（英文）")
    private String dishesModelEn;

    @ApiModelProperty(value = "单价")
    private BigDecimal dishesPrice;


}
