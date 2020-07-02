package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据规则; InnoDB free: 34816 kB
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysDatarule对象", description="数据规则; InnoDB free: 34816 kB")
public class SysDatarule implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "所属菜单")
    private String menuId;

    @ApiModelProperty(value = "数据规则名称")
    private String name;

    @ApiModelProperty(value = "规则字段")
    private String tField;

    @ApiModelProperty(value = "规则条件")
    private String tExpress;

    @ApiModelProperty(value = "规则值")
    private String tValue;

    @ApiModelProperty(value = "自定义sql")
    private String sqlSegment;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private String delFlag;

    @ApiModelProperty(value = "实体类名")
    @TableField("className")
    private String className;


}
