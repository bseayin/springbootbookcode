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
@ApiModel(value="MachineMonitor对象", description="")
public class MachineMonitor implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "监控点id")
    @TableId("cameraUuid")
    private String cameraUuid;

    @ApiModelProperty(value = "监控点名称")
    @TableField("cameraName")
    private String cameraName;

    @ApiModelProperty(value = "监控点类型")
    @TableField("cameraType")
    private Integer cameraType;

    @ApiModelProperty(value = "通道号")
    @TableField("cameraChannelNum")
    private Integer cameraChannelNum;

    @ApiModelProperty(value = "专业智能类型码")
    @TableField("smartType")
    private String smartType;

    @ApiModelProperty(value = "是否支持智能")
    @TableField("smartSupport")
    private String smartSupport;

    @ApiModelProperty(value = "在线状态")
    @TableField("onLineStatus")
    private Integer onLineStatus;

    @ApiModelProperty(value = "键盘矩阵uuid")
    @TableField("keyBoardCode")
    private String keyBoardCode;

    @ApiModelProperty(value = "排序字段")
    @TableField("orderNum")
    private Integer orderNum;

    @ApiModelProperty(value = "中心uuid")
    @TableField("unitUuid")
    private String unitUuid;

    @TableField("updateTime")
    private Integer updateTime;

    @ApiModelProperty(value = "区域uuid")
    @TableField("regionUuid")
    private String regionUuid;

    @ApiModelProperty(value = "编码设备uuid")
    @TableField("encoderUuid")
    private String encoderUuid;

    @ApiModelProperty(value = "权限集")
    @TableField("resAuths")
    private String resAuths;

    @ApiModelProperty(value = "三维位置信息")
    private String position3d;

    private String floor;


}
