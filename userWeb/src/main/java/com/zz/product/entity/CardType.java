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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CardType对象", description="")
public class CardType implements Serializable {

    private static final long serialVersionUID=1L;

    private Long cardTypeId;

    private String cardTypeName;

    @ApiModelProperty(value = "等级")
    private Integer cardTypeLevel;

    private String cardTypeCompany;

    private LocalDateTime cardTypeCreatetime;

    private LocalDateTime cardTypeUpdatetime;


}
