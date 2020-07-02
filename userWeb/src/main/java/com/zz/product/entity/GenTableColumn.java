package com.zz.product.entity;

import java.math.BigDecimal;
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
 * 业务表字段
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GenTableColumn对象", description="业务表字段")
public class GenTableColumn implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "归属表编号")
    private String genTableId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String comments;

    @ApiModelProperty(value = "列的数据类型的字节长度")
    private String jdbcType;

    @ApiModelProperty(value = "JAVA类型")
    private String javaType;

    @ApiModelProperty(value = "JAVA字段名")
    private String javaField;

    @ApiModelProperty(value = "是否主键")
    private String isPk;

    @ApiModelProperty(value = "是否可为空")
    private String isNull;

    @ApiModelProperty(value = "是否为插入字段")
    private String isInsert;

    @ApiModelProperty(value = "是否编辑字段")
    private String isEdit;

    @ApiModelProperty(value = "是否列表字段")
    private String isList;

    @ApiModelProperty(value = "是否查询字段")
    private String isQuery;

    @ApiModelProperty(value = "查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）")
    private String queryType;

    @ApiModelProperty(value = "字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）")
    private String showType;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "其它设置（扩展字段JSON）")
    private String settings;

    @ApiModelProperty(value = "排序（升序）")
    private BigDecimal sort;

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

    @ApiModelProperty(value = "是否表单显示")
    private String isForm;

    @ApiModelProperty(value = "管理的查询表名")
    @TableField("tableName")
    private String tableName;

    @TableField("fieldLabels")
    private String fieldLabels;

    @TableField("fieldKeys")
    private String fieldKeys;

    @TableField("searchLabel")
    private String searchLabel;

    @TableField("searchKey")
    private String searchKey;

    @TableField("validateType")
    private String validateType;

    private String minLength;

    private String maxLength;

    private String minValue;

    private String maxValue;

    @TableField("dataUrl")
    private String dataUrl;

    private String oldName;

    private String oldComments;

    private String oldJdbcType;

    private String oldIsPk;


}
