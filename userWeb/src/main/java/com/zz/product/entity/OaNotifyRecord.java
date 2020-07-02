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
 * 通知通告发送记录
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OaNotifyRecord对象", description="通知通告发送记录")
public class OaNotifyRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "通知通告ID")
    private String oaNotifyId;

    @ApiModelProperty(value = "接受人")
    private String userId;

    @ApiModelProperty(value = "阅读标记")
    private String readFlag;

    @ApiModelProperty(value = "阅读时间")
    private LocalDateTime readDate;


}
