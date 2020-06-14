package com.xsz.product.form;


import com.xsz.product.domain.DishesModel;
import com.xsz.product.enums.DishesEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author llf
 * @description: 菜品form
 * @date 2020/5/26
 */
@ApiModel
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DishesForm implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键编号
     */
    @ApiModelProperty(value = "主键编号")
    private Long spareId;

    /**
     * 菜品编号
     */
    @ApiModelProperty(value = "菜品编号")
    private String spareCode;

    /**
     * 菜品名
     */
    @ApiModelProperty(value = "菜品名")
    private String spareName;

    /**
     * 菜品英文名
     */
    @ApiModelProperty(value = "菜品英文名")
    private String spareNameEn;


    /**
     * 菜品描述
     */
    @ApiModelProperty(value = "菜品描述")
    private String spareModel;

    /**
     * 显示单价
     */
    @ApiModelProperty(value = "显示单价")
    private String sparePrice;

    /**
     * 菜品状态
     */
    @ApiModelProperty(value = "菜品状态")
    private DishesEnum spareStatus;

    /**
     * 菜品图片
     */
    @ApiModelProperty(value = "菜品图片")
    private String sparePhoto;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;


    @ApiModelProperty(value = "查询菜品父类id")
    private String categoryId;


    @ApiModelProperty(value = "查询创建时间时间")
    private String dishesCreateTime;

    @ApiModelProperty(value = "父类ids")
    private Long[] categoryIds;

    @ApiModelProperty(value = "菜品规格信息")
    private List<DishesModel> dishesModelList;

    public interface Create {

    }

    public interface Update {

    }
}
