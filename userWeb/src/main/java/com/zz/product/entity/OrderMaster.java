package com.zz.product.entity;

import java.math.BigDecimal;
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
@ApiModel(value="OrderMaster对象", description="")
public class OrderMaster implements Serializable {

    private static final long serialVersionUID=1L;

    private String orderId;

    private String buyerAddress;

    private String buyerName;

    private String buyerOpenid;

    private String buyerPhone;

    private LocalDateTime createTime;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private LocalDateTime updateTime;


}
