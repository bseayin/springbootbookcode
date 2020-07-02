package com.zz.product.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 接口列表
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TestInterface对象", description="接口列表")
public class TestInterface implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "接口类型")
    private String type;

    @ApiModelProperty(value = "请求URL")
    private String url;

    @ApiModelProperty(value = "请求body")
    private String body;

    @ApiModelProperty(value = "成功时返回消息")
    private String successmsg;

    @ApiModelProperty(value = "失败时返回消息")
    private String errormsg;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty(value = "接口名称")
    private String name;


}
