package com.zz.product.entity;

import java.time.LocalDateTime;
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
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CardSetMeal对象", description="")
public class CardSetMeal implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "套餐id")
    private Long cardSetMealId;

    @ApiModelProperty(value = "会员卡id")
    private Long cardId;

    @ApiModelProperty(value = "主键id")
    private Long cardMealId;

    @ApiModelProperty(value = "剩余次数")
    private Integer cardMealNumber;

    @ApiModelProperty(value = "绑定开始时间")
    private LocalDateTime cardMealStarttime;

    @ApiModelProperty(value = "有效时间")
    private LocalDateTime cardMealEndtime;

    @ApiModelProperty(value = "剩余分享次数")
    private Integer cardMealSharenumber;


}
