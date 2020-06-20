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
 * 菜品表
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_dishes")
@ApiModel(value="TbDishes对象", description="菜品表")
public class TbDishes implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键编号")
    @TableId(value = "spare_id", type = IdType.AUTO)
    private Long spareId;

    @ApiModelProperty(value = "菜品编号")
    private String spareCode;

    @ApiModelProperty(value = "菜品名")
    private String spareName;

    @ApiModelProperty(value = "菜品英文名")
    private String spareNameEn;

    @ApiModelProperty(value = "菜品类型 （删除）")
    private String spareKind;

    @ApiModelProperty(value = "菜品规格/描述  （只保留描述）")
    private String spareModel;

    @ApiModelProperty(value = "显示单价")
    private String sparePrice;

    @ApiModelProperty(value = "菜品状态 0:已上架;1:已下架;2:已售罄")
    private Integer spareStatus;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime spareCreatetime;

    @ApiModelProperty(value = "更改时间")
    private LocalDateTime spareUpdatetime;

    @ApiModelProperty(value = "创建人ID")
    private Long spareCreateman;

    @ApiModelProperty(value = "修改人ID")
    private Long spareUpdateman;

    @ApiModelProperty(value = "菜品图片")
    private String sparePhoto;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "图片路径")
    private String photoPath;


}
