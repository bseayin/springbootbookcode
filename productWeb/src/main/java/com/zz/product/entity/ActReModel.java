package com.zz.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ActReModel对象", description="")
public class ActReModel implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID_")
    private String id;

    @TableField("REV_")
    private Integer rev;

    @TableField("NAME_")
    private String name;

    @TableField("KEY_")
    private String key;

    @TableField("CATEGORY_")
    private String category;

    @TableField("CREATE_TIME_")
    private LocalDateTime createTime;

    @TableField("LAST_UPDATE_TIME_")
    private LocalDateTime lastUpdateTime;

    @TableField("VERSION_")
    private Integer version;

    @TableField("META_INFO_")
    private String metaInfo;

    @TableField("DEPLOYMENT_ID_")
    private String deploymentId;

    @TableField("EDITOR_SOURCE_VALUE_ID_")
    private String editorSourceValueId;

    @TableField("EDITOR_SOURCE_EXTRA_VALUE_ID_")
    private String editorSourceExtraValueId;

    @TableField("TENANT_ID_")
    private String tenantId;


}
