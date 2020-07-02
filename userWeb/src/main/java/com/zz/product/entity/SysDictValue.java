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
 * 字典值
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysDictValue对象", description="字典值")
public class SysDictValue implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "标签名")
    private String dictTypeId;

    @ApiModelProperty(value = "键")
    private String label;

    @ApiModelProperty(value = "值")
    private String value;

    @ApiModelProperty(value = "排序")
    private String sort;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private String delFlag;


}
