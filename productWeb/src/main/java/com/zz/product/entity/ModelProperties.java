package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="ModelProperties对象", description="")
public class ModelProperties implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("domainId")
    private Integer domainId;

    @TableField("propertyId")
    private Integer propertyId;

    @TableField("elementId")
    private Integer elementId;

    @TableField("propertyName")
    private String propertyName;

    @TableField("propertyValue")
    private String propertyValue;


}
