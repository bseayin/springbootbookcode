package com.zz.entity;


import com.zz.enums.OrderStatusEnum;
import com.zz.enums.PayStatusEnum;
import com.zz.enums.PayTypeEnum;
import com.zz.enums.PrintStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bsea
 * 2019-06-11 17:08
 * 订单主实体
 */
@Entity
@Getter
@Setter
@DynamicUpdate
public class OrderMaster {

    /** 订单id. */
    @Id
    @Column(length=30)
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 买家id. */
    private String buyerId;

    /** 卖家id. */
    private String sellerId;

    /** 创建订单人. */
    private String createById;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 支付类型, 默认为0微信支付. */
    private Integer payType = PayTypeEnum.WECHATPAY.getCode();

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    /** 订单备注. */
    private String orderRemarks;

    /** 小票状态, 默认为0未打印. */
    private Integer orderIsprint = PrintStatusEnum.WAIT.getCode();

    @OneToMany(mappedBy = "orderMaster")
    private Set<OrderDetail> orderDetailSet =new HashSet<OrderDetail>();


}
