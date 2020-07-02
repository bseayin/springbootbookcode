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
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ActRuIdentitylink对象", description="")
public class ActRuIdentitylink implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("REV_")
    private Integer rev;

    @TableField("GROUP_ID_")
    private String groupId;

    @TableField("TYPE_")
    private String type;

    @TableField("USER_ID_")
    private String userId;

    @TableField("TASK_ID_")
    private String taskId;

    @TableField("PROC_INST_ID_")
    private String procInstId;

    @TableField("PROC_DEF_ID_")
    private String procDefId;


}
