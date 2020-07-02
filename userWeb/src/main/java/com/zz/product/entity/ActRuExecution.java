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
@ApiModel(value="ActRuExecution对象", description="")
public class ActRuExecution implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("REV_")
    private Integer rev;

    @TableField("PROC_INST_ID_")
    private String procInstId;

    @TableField("BUSINESS_KEY_")
    private String businessKey;

    @TableField("PARENT_ID_")
    private String parentId;

    @TableField("PROC_DEF_ID_")
    private String procDefId;

    @TableField("SUPER_EXEC_")
    private String superExec;

    @TableField("ACT_ID_")
    private String actId;

    @TableField("IS_ACTIVE_")
    private Integer isActive;

    @TableField("IS_CONCURRENT_")
    private Integer isConcurrent;

    @TableField("IS_SCOPE_")
    private Integer isScope;

    @TableField("IS_EVENT_SCOPE_")
    private Integer isEventScope;

    @TableField("SUSPENSION_STATE_")
    private Integer suspensionState;

    @TableField("CACHED_ENT_STATE_")
    private Integer cachedEntState;

    @TableField("TENANT_ID_")
    private String tenantId;

    @TableField("NAME_")
    private String name;

    @TableField("LOCK_TIME_")
    private LocalDateTime lockTime;


}
