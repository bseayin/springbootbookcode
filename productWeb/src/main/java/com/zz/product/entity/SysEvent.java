package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="SysEvent对象", description="")
public class SysEvent implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "事件类型")
    @TableId("eventType")
    private String eventType;

    @ApiModelProperty(value = "子系统id")
    @TableField("subSystemUuid")
    private String subSystemUuid;

    @ApiModelProperty(value = "事件名字")
    @TableField("eventTypeName")
    private String eventTypeName;

    @ApiModelProperty(value = "是否发送 0不可发送 1可发送")
    @TableField("sendFlag")
    private String sendFlag;


}
