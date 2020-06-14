package com.xsz.product.dto;


import com.xsz.product.domain.DishesModel;
import com.xsz.product.enums.DishesEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author llf
 * @description: 菜品Dto
 * @date 2020/5/26
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DishesDTO implements Serializable {
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
     * 菜品类型
     */
    @ApiModelProperty(value = "菜品类型")
    private String spareKind;

    /**
     * 菜品规格/描述
     */
    @ApiModelProperty(value = "菜品规格/描述")
    private String spareModel;

    /**
     * 显示单价
     */
    @ApiModelProperty(value = "显示单价单价")
    private String sparePrice;

    /**
     * 菜品状态
     */
    @ApiModelProperty(value = "菜品状态")
    private DishesEnum spareStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date spareCreatetime;

    /**
     * 更改时间
     */
    @ApiModelProperty(value = "更改时间")
    private Date spareUpdatetime;

    /**
     * 创建人ID
     */
    @ApiModelProperty(value = "创建人ID")
    private Long spareCreateman;

    /**
     * 修改人ID
     */
    @ApiModelProperty(value = "修改人ID")
    private Long spareUpdateman;

    /**
     * 菜品图片
     */
    @ApiModelProperty(value = "菜品图片")
    private String sparePhoto;

    /**
     * 菜品图片地址
     */
    @ApiModelProperty(value = "菜品图片地址")
    private String photoPath;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 菜品分类名称
     */
    private String categoryName;


    @ApiModelProperty(value = "菜品父类id")
    private Long categoryId;


    @ApiModelProperty(value = "查询创建时间开始时间")
    private String beginDate;

    @ApiModelProperty(value = "查询创建时间结束时间")
    private String endDate;

    @ApiModelProperty(value = "查询创建时间时间")
    private String dishesCreateTime;

    @ApiModelProperty(value = "菜品规格列表")
    private List<DishesModel> dishesModelList;
}
