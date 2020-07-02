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
@ApiModel(value="ActHiActinst对象", description="")
public class ActHiActinst implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("PROC_DEF_ID_")
    private String procDefId;

    @TableField("PROC_INST_ID_")
    private String procInstId;

    @TableField("EXECUTION_ID_")
    private String executionId;

    @TableField("ACT_ID_")
    private String actId;

    @TableField("TASK_ID_")
    private String taskId;

    @TableField("CALL_PROC_INST_ID_")
    private String callProcInstId;

    @TableField("ACT_NAME_")
    private String actName;

    @TableField("ACT_TYPE_")
    private String actType;

    @TableField("ASSIGNEE_")
    private String assignee;

    @TableField("START_TIME_")
    private LocalDateTime startTime;

    @TableField("END_TIME_")
    private LocalDateTime endTime;

    @TableField("DURATION_")
    private Long duration;

    @TableField("TENANT_ID_")
    private String tenantId;


}
