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
@ApiModel(value="MachinePhoto对象", description="")
public class MachinePhoto implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "设备编号")
    @TableId("encoderUuid")
    private String encoderUuid;

    @ApiModelProperty(value = "设备名称")
    @TableField("encoderName")
    private String encoderName;

    @ApiModelProperty(value = "设备类型码")
    @TableField("encoderModel")
    private String encoderModel;

    @ApiModelProperty(value = "设备用户名")
    @TableField("encoderUserName")
    private String encoderUserName;

    @ApiModelProperty(value = "设备密码")
    @TableField("encoderUserPwd")
    private String encoderUserPwd;

    @ApiModelProperty(value = "设备端口号")
    @TableField("encoderPort")
    private Integer encoderPort;

    @ApiModelProperty(value = "设备ip地址")
    @TableField("encoderIp")
    private String encoderIp;

    @ApiModelProperty(value = "专业智能设备码")
    @TableField("smartType")
    private String smartType;

    @ApiModelProperty(value = "是否支持智能设备")
    @TableField("smartSupport")
    private Integer smartSupport;

    @ApiModelProperty(value = "海康设备码")
    @TableField("devType")
    private String devType;

    @ApiModelProperty(value = "排序字段")
    @TableField("orderNum")
    private Integer orderNum;

    @ApiModelProperty(value = "中心uuid")
    @TableField("unitUuid")
    private String unitUuid;

    @TableField("updateTime")
    private Integer updateTime;

    @ApiModelProperty(value = "报警输入")
    @TableField("alarmIn")
    private Integer alarmIn;

    @ApiModelProperty(value = "报警输出")
    @TableField("alarmOut")
    private Integer alarmOut;

    @ApiModelProperty(value = "对讲通道号")
    @TableField("visIntercomChanNum")
    private Integer visIntercomChanNum;

    @ApiModelProperty(value = "权限集")
    @TableField("resAuths")
    private String resAuths;

    @ApiModelProperty(value = "三维位置信息")
    private String position3d;

    @TableField("machineType")
    private String machineType;


}
