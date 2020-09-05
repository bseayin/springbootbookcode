package com.xsz.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="QrtzPausedTriggerGrps对象", description="")
public class QrtzPausedTriggerGrps implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("SCHED_NAME")
    private String schedName;

    @TableField("TRIGGER_GROUP")
    private String triggerGroup;


}
