package com.zz.product.entity;

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
@TableName("tb_product_category")
@ApiModel(value="ProductCategory对象", description="")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
