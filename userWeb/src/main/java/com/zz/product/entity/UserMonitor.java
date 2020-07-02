package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户摄像头资源表
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserMonitor对象", description="用户摄像头资源表")
public class UserMonitor implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId("recordUuid")
    private String recordUuid;

    @ApiModelProperty(value = "用户标识")
    @TableField("userId")
    private String userId;

    @ApiModelProperty(value = "摄像头标识")
    @TableField("cameraUuid")
    private String cameraUuid;

    @ApiModelProperty(value = "权限集: 1内网可见, 2外网可见")
    private Integer auths;

    @TableField("updateTime")
    private LocalDateTime updateTime;


}
