package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="QrtzSimpleTriggers对象", description="")
public class QrtzSimpleTriggers implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("SCHED_NAME")
    private String schedName;

    @TableField("TRIGGER_NAME")
    private String triggerName;

    @TableField("TRIGGER_GROUP")
    private String triggerGroup;

    @TableField("REPEAT_COUNT")
    private Long repeatCount;

    @TableField("REPEAT_INTERVAL")
    private Long repeatInterval;

    @TableField("TIMES_TRIGGERED")
    private Long timesTriggered;


}
