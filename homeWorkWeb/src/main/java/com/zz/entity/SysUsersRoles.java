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
@ApiModel(value="SysUsersRoles对象", description="")
public class SysUsersRoles implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    @Id
    private Long id;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "角色编号")
    private Long roleId;


}
