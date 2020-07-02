package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
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
@ApiModel(value="ActEvtLog对象", description="")
public class ActEvtLog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "LOG_NR_", type = IdType.AUTO)
    private Long logNr;

    @TableField("TYPE_")
    private String type;

    @TableField("PROC_DEF_ID_")
    private String procDefId;

    @TableField("PROC_INST_ID_")
    private String procInstId;

    @TableField("EXECUTION_ID_")
    private String executionId;

    @TableField("TASK_ID_")
    private String taskId;

    @TableField("TIME_STAMP_")
    private LocalDateTime timeStamp;

    @TableField("USER_ID_")
    private String userId;

    @TableField("DATA_")
    private Blob data;

    @TableField("LOCK_OWNER_")
    private String lockOwner;

    @TableField("LOCK_TIME_")
    private LocalDateTime lockTime;

    @TableField("IS_PROCESSED_")
    private Integer isProcessed;


}
