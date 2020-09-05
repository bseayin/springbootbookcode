package com.xsz.product.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class CategoryForm implements Serializable {
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
    @NotBlank(groups = {Create.class,Update.class}, message = "一级菜单名称不能为空")
    private String categoryName;

    /**
     * 一级菜单所属店铺id
     */
    @ApiModelProperty(value = "一级菜单所属店铺id")
    @NotNull(groups = {Create.class,Update.class}, message = "一级菜单所属店铺id不能为空")
    private Long categoryCompanyid;

    /**
     * 一级菜单英文名
     */
    @ApiModelProperty(value = "一级菜单英文名")
    private String categoryNameEn;

    @ApiModelProperty(value = "查询创建时间时间")
    private String categoryCreateTime;


    public interface Create {

    }

    public interface Update {

    }
}