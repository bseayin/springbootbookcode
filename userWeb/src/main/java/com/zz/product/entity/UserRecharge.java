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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserRecharge对象", description="")
public class UserRecharge implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键 充值表id")
    private String rechargeId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "充值金额")
    private Integer payAmount;

    @ApiModelProperty(value = "充值时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "介绍时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "交易编号")
    private String transactionId;

    @ApiModelProperty(value = "支付状态（0未完成支付、1支付成功）")
    private Integer payStatus;

    @ApiModelProperty(value = "支付类型（1微信支付、2支付宝支付）")
    private Integer payType;

    @ApiModelProperty(value = "股东id（会员充值的每一笔金额，股东都分红）")
    private String shareholderId;

    @ApiModelProperty(value = "商品id")
    private Integer itemId;

    @ApiModelProperty(value = "1微信商场、2到店开单")
    private Integer orderSource;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "充值所属门店")
    private String shopSource;

    @ApiModelProperty(value = "实际支付金额")
    private Integer realityPayAmount;


}
