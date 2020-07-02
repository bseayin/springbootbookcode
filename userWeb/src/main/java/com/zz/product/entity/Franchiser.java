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
@ApiModel(value="Franchiser对象", description="")
public class Franchiser implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;

    private String phone;

    private String address;

    @ApiModelProperty(value = "是否是总店  0不是总店 1总店")
    private String isMain;

    private LocalDateTime updateTime;

    private Long franchiserId;


}
