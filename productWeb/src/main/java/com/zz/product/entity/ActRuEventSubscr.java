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
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ActRuEventSubscr对象", description="")
public class ActRuEventSubscr implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("REV_")
    private Integer rev;

    @TableField("EVENT_TYPE_")
    private String eventType;

    @TableField("EVENT_NAME_")
    private String eventName;

    @TableField("EXECUTION_ID_")
    private String executionId;

    @TableField("PROC_INST_ID_")
    private String procInstId;

    @TableField("ACTIVITY_ID_")
    private String activityId;

    @TableField("CONFIGURATION_")
    private String configuration;

    @TableField("CREATED_")
    private LocalDateTime created;

    @TableField("PROC_DEF_ID_")
    private String procDefId;

    @TableField("TENANT_ID_")
    private String tenantId;


}
