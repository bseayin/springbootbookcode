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
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MachineWifi对象", description="")
public class MachineWifi implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "mac地址")
    private String macAddress;

    @ApiModelProperty(value = "网络id")
    private String netId;

    @ApiModelProperty(value = "图片")
    private String photo;

    @ApiModelProperty(value = "信号范围")
    private Integer area;

    @ApiModelProperty(value = "描述")
    private String remark;


}
