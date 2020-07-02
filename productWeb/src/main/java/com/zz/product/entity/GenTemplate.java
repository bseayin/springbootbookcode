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
 * 代码模板表
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GenTemplate对象", description="代码模板表")
public class GenTemplate implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "生成文件路径")
    private String filePath;

    @ApiModelProperty(value = "生成文件名")
    private String fileName;

    @ApiModelProperty(value = "内容")
    private String content;

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


}
