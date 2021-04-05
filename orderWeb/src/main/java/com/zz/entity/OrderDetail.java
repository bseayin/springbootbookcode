package com.zz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Bsea
 * 2019-06-11 17:20
 * 订单详情实体
 */
@Entity
@Data
public class OrderDetail {

    @Id
    @Column(length=30)
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;
    /** 主订单记录. */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="orderMaster_id")
    private OrderMaster orderMaster;
}
