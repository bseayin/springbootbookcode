package com.zz.product.entity;

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
@ApiModel(value="ActHiComment对象", description="")
public class ActHiComment implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("TYPE_")
    private String type;

    @TableField("TIME_")
    private LocalDateTime time;

    @TableField("USER_ID_")
    private String userId;

    @TableField("TASK_ID_")
    private String taskId;

    @TableField("PROC_INST_ID_")
    private String procInstId;

    @TableField("ACTION_")
    private String action;

    @TableField("MESSAGE_")
    private String message;

    @TableField("FULL_MSG_")
    private Blob fullMsg;


}
