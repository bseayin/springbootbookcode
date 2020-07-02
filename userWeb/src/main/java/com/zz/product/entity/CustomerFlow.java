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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CustomerFlow对象", description="")
public class CustomerFlow implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "监控点id")
    @TableId("cameraUuid")
    private String cameraUuid;

    @ApiModelProperty(value = "客流开始时间")
    @TableField("footfallStartTime")
    private String footfallStartTime;

    @ApiModelProperty(value = "客流结束时间")
    @TableField("footfallEndTime")
    private String footfallEndTime;

    @ApiModelProperty(value = "客流事件")
    @TableField("footfallTime")
    private String footfallTime;

    @ApiModelProperty(value = "进客流量")
    @TableField("passengersIn")
    private Integer passengersIn;

    @ApiModelProperty(value = "出客流量")
    @TableField("passengersOut")
    private Integer passengersOut;

    private String day;

    private String month;

    private String year;

    private String hour;

    private String minute;

    private String second;


}
