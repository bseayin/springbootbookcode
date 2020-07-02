package com.zz.product.entity;

import java.math.BigDecimal;
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
@ApiModel(value="UserWithdrawal对象", description="")
public class UserWithdrawal implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "提现单id")
    private String id;

    @ApiModelProperty(value = "提现用户id")
    private String userId;

    @ApiModelProperty(value = "提现类型（0为会员提现，1为股东提现）")
    private Integer withdrawType;

    @ApiModelProperty(value = "提现方式（0为支付宝提现，1为银行卡提现）")
    private Integer withdrawMethod;

    @ApiModelProperty(value = "提现账号")
    private String accountNum;

    @ApiModelProperty(value = "提现金额")
    private BigDecimal withdrawMoney;

    @ApiModelProperty(value = "用户账号余额")
    private BigDecimal userBalance;

    @ApiModelProperty(value = "提现状态（0提现中，1提现成功）")
    private Integer withdrawStatus;

    @ApiModelProperty(value = "处理人id")
    private String handlerId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "用户所属门店")
    private String userOfShop;

    @ApiModelProperty(value = "提现账号所属人名")
    private String takeName;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "银行地址(省市)")
    private String bankAddress;

    @ApiModelProperty(value = "银行详细支行名称")
    private String bankOwnerName;


}
