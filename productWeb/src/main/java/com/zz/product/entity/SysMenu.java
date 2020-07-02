package com.zz.product.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysMenu对象", description="菜单表")
public class SysMenu implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "父级编号")
    private String parentId;

    @ApiModelProperty(value = "所有父级编号")
    private String parentIds;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private BigDecimal sort;

    @ApiModelProperty(value = "链接")
    private String href;

    @ApiModelProperty(value = "目标")
    private String target;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "是否在菜单中显示")
    private String isShow;

    @ApiModelProperty(value = "权限标识")
    private String permission;

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

    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty(value = "0:功能菜单  1：菜单  2：按钮  3：数据权限")
    private String menuType;

    private String zhibuId;


}
