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
@ApiModel(value="EventLog对象", description="")
public class EventLog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "日志 Id")
    @TableId("logId")
    private String logId;

    @ApiModelProperty(value = "事件状态 0 瞬时事件 1 事件开始 2 事件结束 3 事件脉冲 4 事件更新")
    @TableField("eventState")
    private Integer eventState;

    @ApiModelProperty(value = "事件等级 ")
    @TableField("eventLevel")
    private Integer eventLevel;

    @ApiModelProperty(value = "控制中心编号")
    @TableField("unitIdx")
    private String unitIdx;

    @ApiModelProperty(value = "事件类型")
    @TableField("eventType")
    private Integer eventType;

    @ApiModelProperty(value = "事件类型名称")
    @TableField("eventTypeName")
    private String eventTypeName;

    @ApiModelProperty(value = "事件名称")
    @TableField("eventName")
    private String eventName;

    @ApiModelProperty(value = "开始时间")
    @TableField("startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("stopTime")
    private String stopTime;

    @ApiModelProperty(value = "事件源编号")
    @TableField("sourceIdx")
    private String sourceIdx;

    @ApiModelProperty(value = "事件源类型")
    @TableField("sourceType")
    private Integer sourceType;

    @ApiModelProperty(value = "事件源名称")
    @TableField("sourceName")
    private String sourceName;

    @ApiModelProperty(value = "事件描述信息")
    @TableField("logTex")
    private String logTex;

    @ApiModelProperty(value = "事件源区域编号")
    @TableField("regionIdx")
    private String regionIdx;

    @ApiModelProperty(value = "事件扩展信息")
    @TableField("extInfo")
    private String extInfo;

    @ApiModelProperty(value = "userid数组")
    @TableField("userIds")
    private String userIds;


}
