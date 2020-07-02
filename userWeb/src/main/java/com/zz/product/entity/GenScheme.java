package com.zz.product.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 生成方案
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GenScheme对象", description="生成方案")
public class GenScheme implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "生成包路径")
    private String packageName;

    @ApiModelProperty(value = "生成模块名")
    private String moduleName;

    @ApiModelProperty(value = "生成子模块名")
    private String subModuleName;

    @ApiModelProperty(value = "生成功能名")
    private String functionName;

    @ApiModelProperty(value = "生成功能名（简写）")
    private String functionNameSimple;

    @ApiModelProperty(value = "生成功能作者")
    private String functionAuthor;

    @ApiModelProperty(value = "生成表编号")
    private String genTableId;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "删除标记（0：正常；1：删除）")
    private String delFlag;

    @ApiModelProperty(value = "表单风格")
    private String formStyle;

    @ApiModelProperty(value = "路径")
    private String projectpath;


}
