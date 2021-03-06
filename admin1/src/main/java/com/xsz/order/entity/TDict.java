package com.xsz.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="TDict对象", description="")
public class TDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典ID")
    @TableId(value = "DICT_ID", type = IdType.AUTO)
    private Long dictId;

    @ApiModelProperty(value = "键")
    @TableField("KEYY")
    private Long keyy;

    @ApiModelProperty(value = "值")
    @TableField("VALUEE")
    private String valuee;

    @ApiModelProperty(value = "字段名称")
    @TableField("FIELD_NAME")
    private String fieldName;

    @ApiModelProperty(value = "表名")
    @TableField("TABLE_NAME")
    private String tableName;


}
