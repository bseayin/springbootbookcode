package com.zz.form;

import com.zz.entity.OrderDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bsea
 * 2019-06-18 23:31
 */
@Data
@ApiModel
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 买家手机号
     */
    @ApiModelProperty(value = "买家手机号")
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @ApiModelProperty(value = "买家地址")
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid
     */
    @ApiModelProperty(value = "买家微信openid")
    @NotEmpty(message = "openid必填")
    private String openid;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;
    /**
     * 卖家id
     */
    @ApiModelProperty(value = "卖家id")
    private String companyid;


    /**
     * 购物车
     */
    @ApiModelProperty(value = "购物车")
    @NotEmpty(message = "购物车不能为空")
    private Set<OrderDetail> orderDetailSet =new HashSet<OrderDetail>();
}
