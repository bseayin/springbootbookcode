package com.zz.product.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tb_product_info")
@ApiModel(value="ProductInfo对象", description="")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID=1L;

    private String productId;

    private Integer categoryType;

    private LocalDateTime createTime;

    private String productDescription;

    private String productIcon;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStatus;

    private Integer productStock;

    private LocalDateTime updateTime;


}
