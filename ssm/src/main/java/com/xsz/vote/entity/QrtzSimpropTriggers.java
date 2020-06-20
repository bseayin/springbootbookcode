package com.xsz.vote.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("qrtz_simprop_triggers")
@ApiModel(value="QrtzSimpropTriggers对象", description="")
public class QrtzSimpropTriggers implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("SCHED_NAME")
    private String schedName;

    @TableField("TRIGGER_NAME")
    private String triggerName;

    @TableField("TRIGGER_GROUP")
    private String triggerGroup;

    @TableField("STR_PROP_1")
    private String strProp1;

    @TableField("STR_PROP_2")
    private String strProp2;

    @TableField("STR_PROP_3")
    private String strProp3;

    @TableField("INT_PROP_1")
    private Integer intProp1;

    @TableField("INT_PROP_2")
    private Integer intProp2;

    @TableField("LONG_PROP_1")
    private Long longProp1;

    @TableField("LONG_PROP_2")
    private Long longProp2;

    @TableField("DEC_PROP_1")
    private BigDecimal decProp1;

    @TableField("DEC_PROP_2")
    private BigDecimal decProp2;

    @TableField("BOOL_PROP_1")
    private String boolProp1;

    @TableField("BOOL_PROP_2")
    private String boolProp2;


}
