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
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ShopOrder对象", description="")
public class ShopOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Long shopOrderId;

    @ApiModelProperty(value = "消费账户id")
    private String shopOrderUser;

    @ApiModelProperty(value = "创建id")
    private String shopOrderCreateman;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime shopOrderCreatetime;

    @ApiModelProperty(value = "单号")
    private String shopOrderCode;

    @ApiModelProperty(value = "备注")
    private String shopOrderRemarks;

    @ApiModelProperty(value = "状态 0-挂单 1 结算")
    private Integer shopOrderStatus;

    @ApiModelProperty(value = "订单归属商户")
    private String shopOrderCompanyid;

    @ApiModelProperty(value = "消费用户姓名")
    private String shopOrderName;

    @ApiModelProperty(value = "车牌号（优惠前原价）")
    private String shopOrderCarnumber;

    @ApiModelProperty(value = "电话")
    private String shopOrderPhone;

    @ApiModelProperty(value = "车辆类型（外卖地址）")
    private String shopOrderCartype;

    @ApiModelProperty(value = "车辆品牌 （所属学校）")
    private String shopOrderCarbrand;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal shopOrderTotalprice;

    @ApiModelProperty(value = "用户 消费时持有的card id")
    private String shopOrderUserCard;

    @ApiModelProperty(value = "支付方式 0-现金 1-会员卡余额 2-微信")
    private Integer shopOrderPaytype;

    @ApiModelProperty(value = "修改人")
    private String shopOrderUpdateman;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime shopOrderUpdatetime;

    @ApiModelProperty(value = "是否打印（0未打印，1待打印，2已打印）")
    private Integer shopOrderIsprint;

    @ApiModelProperty(value = "分红通知（0未通知，1待通知，2已通知）")
    private Integer shopOrderNotify;

    @ApiModelProperty(value = "0-未计算分红 1-已做")
    private Integer shopOrderDodevidend;


}
