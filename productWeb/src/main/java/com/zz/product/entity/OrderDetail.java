package com.zz.product.entity;

import java.math.BigDecimal;
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
@ApiModel(value="OrderDetail对象", description="")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID=1L;

    private String detailId;

    private String orderId;

    private String productIcon;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;


}
