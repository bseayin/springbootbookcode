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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ActHiTaskinst对象", description="")
public class ActHiTaskinst implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("PROC_DEF_ID_")
    private String procDefId;

    @TableField("TASK_DEF_KEY_")
    private String taskDefKey;

    @TableField("PROC_INST_ID_")
    private String procInstId;

    @TableField("EXECUTION_ID_")
    private String executionId;

    @TableField("NAME_")
    private String name;

    @TableField("PARENT_TASK_ID_")
    private String parentTaskId;

    @TableField("DESCRIPTION_")
    private String description;

    @TableField("OWNER_")
    private String owner;

    @TableField("ASSIGNEE_")
    private String assignee;

    @TableField("START_TIME_")
    private LocalDateTime startTime;

    @TableField("CLAIM_TIME_")
    private LocalDateTime claimTime;

    @TableField("END_TIME_")
    private LocalDateTime endTime;

    @TableField("DURATION_")
    private Long duration;

    @TableField("DELETE_REASON_")
    private String deleteReason;

    @TableField("PRIORITY_")
    private Integer priority;

    @TableField("DUE_DATE_")
    private LocalDateTime dueDate;

    @TableField("FORM_KEY_")
    private String formKey;

    @TableField("CATEGORY_")
    private String category;

    @TableField("TENANT_ID_")
    private String tenantId;


}
