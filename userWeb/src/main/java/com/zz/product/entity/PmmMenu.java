package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PmmMenu对象", description="")
public class PmmMenu implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "菜单编号")
    @TableId("menuId")
    private String menuId;

    @ApiModelProperty(value = "菜单名称")
    @TableField("menuName")
    private String menuName;

    @ApiModelProperty(value = "父节点id")
    @TableField("menuPid")
    private String menuPid;

    @ApiModelProperty(value = "菜单url")
    @TableField("menuUrl")
    private String menuUrl;

    @ApiModelProperty(value = "菜单类型 1一级 2二级")
    @TableField("dataType")
    private String dataType;

    @ApiModelProperty(value = "菜单状态 1正常 2停用")
    private String status;

    @ApiModelProperty(value = "说明")
    private String remark;

    @TableField("orderId")
    private String orderId;


}
