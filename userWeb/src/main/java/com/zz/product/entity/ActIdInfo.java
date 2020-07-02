package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
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
@ApiModel(value="ActIdInfo对象", description="")
public class ActIdInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("REV_")
    private Integer rev;

    @TableField("USER_ID_")
    private String userId;

    @TableField("TYPE_")
    private String type;

    @TableField("KEY_")
    private String key;

    @TableField("VALUE_")
    private String value;

    @TableField("PASSWORD_")
    private Blob password;

    @TableField("PARENT_ID_")
    private String parentId;


}
