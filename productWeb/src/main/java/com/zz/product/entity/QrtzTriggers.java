package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="QrtzTriggers对象", description="")
public class QrtzTriggers implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("SCHED_NAME")
    private String schedName;

    @TableField("TRIGGER_NAME")
    private String triggerName;

    @TableField("TRIGGER_GROUP")
    private String triggerGroup;

    @TableField("JOB_NAME")
    private String jobName;

    @TableField("JOB_GROUP")
    private String jobGroup;

    @TableField("DESCRIPTION")
    private String description;

    @TableField("NEXT_FIRE_TIME")
    private Long nextFireTime;

    @TableField("PREV_FIRE_TIME")
    private Long prevFireTime;

    @TableField("PRIORITY")
    private Integer priority;

    @TableField("TRIGGER_STATE")
    private String triggerState;

    @TableField("TRIGGER_TYPE")
    private String triggerType;

    @TableField("START_TIME")
    private Long startTime;

    @TableField("END_TIME")
    private Long endTime;

    @TableField("CALENDAR_NAME")
    private String calendarName;

    @TableField("MISFIRE_INSTR")
    private Integer misfireInstr;

    @TableField("JOB_DATA")
    private Blob jobData;


}
