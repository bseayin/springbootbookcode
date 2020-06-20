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
@TableName("tb_order")
@ApiModel(value="TbOrder对象", description="订单表")
public class TbOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单主键编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单单号")
    private String orderId;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "商铺编号")
    private Long companyId;

    @ApiModelProperty(value = "订单状态")
    private String status;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "实际支付总价")
    private BigDecimal paymentAmount;

    @ApiModelProperty(value = "收货人姓名")
    private String orderUserName;

    @ApiModelProperty(value = "送餐地址")
    private String address;

    @ApiModelProperty(value = "订单电话")
    private String tel;

    @ApiModelProperty(value = "取餐方式")
    private String takeFoodWay;

    @ApiModelProperty(value = "取餐时间")
    private LocalDateTime takeMealTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人ID")
    private Long createAccountId;

    @ApiModelProperty(value = "修改人ID")
    private Long updateAccountId;

    @ApiModelProperty(value = "备注")
    private String remark;


}
