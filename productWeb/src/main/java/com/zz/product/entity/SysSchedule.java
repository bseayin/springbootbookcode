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
 * 定时任务
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysSchedule对象", description="定时任务")
public class SysSchedule implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "任务名")
    private String name;

    @ApiModelProperty(value = "任务组")
    private String tGroup;

    @ApiModelProperty(value = "定时规则")
    private String expression;

    @ApiModelProperty(value = "启用状态")
    private String status;

    @ApiModelProperty(value = "通知用户")
    private String isInfo;

    @ApiModelProperty(value = "任务类")
    private String classname;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private String delFlag;


}
