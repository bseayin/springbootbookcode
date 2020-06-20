package com.xsz.vote.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_category_dishes")
@ApiModel(value="TbCategoryDishes对象", description="")
public class TbCategoryDishes implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "菜品父类分类id")
    private Long categoryId;

    @ApiModelProperty(value = "菜品id")
    private Long spareId;


}
