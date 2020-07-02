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
@ApiModel(value="ActRuJob对象", description="")
public class ActRuJob implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("REV_")
    private Integer rev;

    @TableField("TYPE_")
    private String type;

    @TableField("LOCK_EXP_TIME_")
    private LocalDateTime lockExpTime;

    @TableField("LOCK_OWNER_")
    private String lockOwner;

    @TableField("EXCLUSIVE_")
    private Boolean exclusive;

    @TableField("EXECUTION_ID_")
    private String executionId;

    @TableField("PROCESS_INSTANCE_ID_")
    private String processInstanceId;

    @TableField("PROC_DEF_ID_")
    private String procDefId;

    @TableField("RETRIES_")
    private Integer retries;

    @TableField("EXCEPTION_STACK_ID_")
    private String exceptionStackId;

    @TableField("EXCEPTION_MSG_")
    private String exceptionMsg;

    @TableField("DUEDATE_")
    private LocalDateTime duedate;

    @TableField("REPEAT_")
    private String repeat;

    @TableField("HANDLER_TYPE_")
    private String handlerType;

    @TableField("HANDLER_CFG_")
    private String handlerCfg;

    @TableField("TENANT_ID_")
    private String tenantId;


}
