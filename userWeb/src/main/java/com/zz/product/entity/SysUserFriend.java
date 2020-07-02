package com.zz.product.entity;

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
@ApiModel(value="SysUserFriend对象", description="")
public class SysUserFriend implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @TableField("userId")
    private String userId;

    @TableField("friendId")
    private String friendId;


}
