package com.zz.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bsea
 * @since 2019-12-25
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysRoles对象", description="")
public class SysRoles implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "角色编号")
    @Id
    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String role;

    @ApiModelProperty(value = "角色描述")
    private String description;

    @ApiModelProperty(value = "父节点")
    private Long pid;

    @ApiModelProperty(value = "是否锁定")
    private Boolean available;


}
