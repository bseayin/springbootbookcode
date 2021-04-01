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
@ApiModel(value="ActHiVarinst对象", description="")
public class ActHiVarinst implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("PROC_INST_ID_")
    private String procInstId;

    @TableField("EXECUTION_ID_")
    private String executionId;

    @TableField("TASK_ID_")
    private String taskId;

    @TableField("NAME_")
    private String name;

    @TableField("VAR_TYPE_")
    private String varType;

    @TableField("REV_")
    private Integer rev;

    @TableField("BYTEARRAY_ID_")
    private String bytearrayId;

//    @TableField("DOUBLE_")
//    private Double double;
//
//    @TableField("LONG_")
//    private Long long;

    @TableField("TEXT_")
    private String text;

    @TableField("TEXT2_")
    private String text2;

    @TableField("CREATE_TIME_")
    private LocalDateTime createTime;

    @TableField("LAST_UPDATED_TIME_")
    private LocalDateTime lastUpdatedTime;


}
