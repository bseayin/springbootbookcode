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
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserAdvice对象", description="")
public class UserAdvice implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id，时间戳")
    private LocalDateTime id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "建议反馈内容")
    private String advice;

    @ApiModelProperty(value = "用户手机号")
    private String userTelephone;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "所属门店id")
    private String companyId;


}
