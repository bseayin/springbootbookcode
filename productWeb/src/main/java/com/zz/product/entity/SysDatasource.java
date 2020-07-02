package com.zz.product.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 多数据源配置
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysDatasource对象", description="多数据源配置")
public class SysDatasource implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "连接英文名")
    private String enname;

    @ApiModelProperty(value = "数据库用户名")
    private String dbUsername;

    @ApiModelProperty(value = "数据库密码")
    private String dbPassword;

    @ApiModelProperty(value = "数据库链接")
    private String dbUrl;

    @ApiModelProperty(value = "数据库驱动类")
    private String dbDriver;

    @ApiModelProperty(value = "连接名称")
    private String name;


}
