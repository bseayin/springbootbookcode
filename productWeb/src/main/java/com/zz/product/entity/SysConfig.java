package com.zz.product.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统配置
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysConfig对象", description="系统配置")
public class SysConfig implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "邮箱服务器地址")
    private String smtp;

    @ApiModelProperty(value = "邮箱服务器端口")
    private String port;

    @ApiModelProperty(value = "系统邮箱地址")
    private String mailname;

    @ApiModelProperty(value = "系统邮箱密码")
    private String mailpassword;

    @ApiModelProperty(value = "短信用户名")
    private String smsname;

    @ApiModelProperty(value = "短信密码")
    private String smspassword;


}
