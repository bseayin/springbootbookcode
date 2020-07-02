package com.zz.product.entity;

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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CardSpareDiscount对象", description="")
public class CardSpareDiscount implements Serializable {

    private static final long serialVersionUID=1L;

    private Long cardSpareDiscountId;

    @ApiModelProperty(value = "card_type id")
    private Long cardId;

    private Long spareId;

    private String discount;


}
