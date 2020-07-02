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
 * 业务表
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GenTable对象", description="业务表")
public class GenTable implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String comments;

    @ApiModelProperty(value = "实体类名称")
    private String className;

    @ApiModelProperty(value = "关联父表")
    private String parentTable;

    @ApiModelProperty(value = "关联父表外键")
    private String parentTableFk;

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

    @ApiModelProperty(value = "同步")
    private String issync;

    @ApiModelProperty(value = "表类型")
    private String tableType;

    @ApiModelProperty(value = "改变前表的名字")
    private String oldName;

    @ApiModelProperty(value = "改变前表的描述")
    private String oldComments;

    @ApiModelProperty(value = "主键策略")
    private String genIdType;

    @ApiModelProperty(value = "改变前主键策略")
    private String oldGenIdType;


}
