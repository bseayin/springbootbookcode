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
 * 日历
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Calendar对象", description="日历")
public class Calendar implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "事件标题")
    private String title;

    @ApiModelProperty(value = "事件开始时间")
    private LocalDateTime starttime;

    @ApiModelProperty(value = "事件结束时间")
    private LocalDateTime endtime;

    @ApiModelProperty(value = "是否为全天时间")
    private String allday;

    @ApiModelProperty(value = "时间的背景色")
    private String color;

    private String userid;


}
