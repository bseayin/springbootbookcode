package com.xsz.order.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbCategoryDishes对象", description="")
public class TbCategoryDishes implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜品父类分类id")
    private Long categoryId;

    @ApiModelProperty(value = "菜品id")
    private Long spareId;


}
