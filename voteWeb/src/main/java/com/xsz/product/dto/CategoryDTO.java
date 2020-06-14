package com.xsz.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @author llf
 * @description: 菜品父类表DTO
 * @date 2020/5/25
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = -4852732617765810959L;
    /**
     * 一级菜单id
     */
    @ApiModelProperty(value = "一级菜单id")
    private Long categoryId;

    /**
     * 一级菜单名称
     */
    @ApiModelProperty(value = "一级菜单名称")
    private String categoryName;

    /**
     * 一级菜单所属店铺id
     */
    @ApiModelProperty(value = "一级菜单所属店铺id")
    private Long categoryCompanyid;

    /**
     * 一级菜单英文名
     */
    @ApiModelProperty(value = "一级菜单英文名")
    private String categoryNameEn;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    /**
     * 更改时间
     */
    @ApiModelProperty(value = "更改时间")
    private Date updatetime;

    /**
     * 创建人ID
     */
    @ApiModelProperty(value = "创建人ID")
    private Long createman;

    /**
     * 修改人ID
     */
    @ApiModelProperty(value = "修改人ID")
    private Long updateman;

    @ApiModelProperty(value = "查询创建时间开始时间")
    private Date beginDate;

    @ApiModelProperty(value = "查询创建时间结束时间")
    private Date endDate;

    @ApiModelProperty(value = "查询创建时间时间")
    private String categoryCreateTime;

}