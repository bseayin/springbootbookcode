package com.xsz.vote.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_shop_order")
@ApiModel(value="TbShopOrder对象", description="订单表")
public class TbShopOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单主键编号")
    @TableId(value = "shop_order_id", type = IdType.AUTO)
    private Long shopOrderId;

    @ApiModelProperty(value = "消费用户编号")
    private Long shopOrderUser;

    @ApiModelProperty(value = "商铺编号")
    private Long shopOrderCompanyid;

    @ApiModelProperty(value = "订单状态 0:未完成;1:已接单;2:下完单;3:加工完;4:已送到;5:已完成")
    private Integer shopOrderStatus;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal shopOrderTotalprice;

    @ApiModelProperty(value = "用户支付实际价格")
    private BigDecimal shopPaymentAmount;

    @ApiModelProperty(value = "收货人姓名")
    private String shopOrderName;

    @ApiModelProperty(value = "收货地址")
    private String shopOrderCartype;

    @ApiModelProperty(value = "收货电话")
    private String shopOrderPhone;

    @ApiModelProperty(value = "订单单号")
    private Long shopOrderCode;

    @ApiModelProperty(value = "取餐方式")
    private String takeFoodWay;

    @ApiModelProperty(value = "取餐时间")
    private LocalDateTime takeMealTime;

    @ApiModelProperty(value = "创建人id")
    private Long shopOrderCreateman;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime shopOrderCreatetime;

    @ApiModelProperty(value = "修改人id")
    private Long shopOrderUpdateman;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime shopOrderUpdatetime;

    @ApiModelProperty(value = "备注")
    private String shopOrderRemarks;


}
