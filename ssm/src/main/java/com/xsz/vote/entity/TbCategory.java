package com.xsz.vote.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜品父类分类表
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_category")
@ApiModel(value="TbCategory对象", description="菜品父类分类表")
public class TbCategory implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "一级菜单id")
    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;

    @ApiModelProperty(value = "一级菜单名称")
    private String categoryName;

    @ApiModelProperty(value = "一级菜单所属店铺id")
    private Long categoryCompanyid;

    @ApiModelProperty(value = "一级菜单英文名")
    private String categoryNameEn;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "更改时间")
    private LocalDateTime updatetime;

    @ApiModelProperty(value = "创建人ID")
    private Long createman;

    @ApiModelProperty(value = "修改人ID")
    private Long updateman;


}
