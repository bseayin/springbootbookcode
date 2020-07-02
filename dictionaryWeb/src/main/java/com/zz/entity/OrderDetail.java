package com.zz.entity;





import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @Description: 订单详情
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
@Entity

public class OrderDetail {
    /**
     * 主键
     */
    @Id
    @Column(length=50)
    private String id;
    /**
     * 数量
     */
    private int num;
    /**
     * 产品id
     */
    private String product_id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="orderMaster_id")
    private OrderMaster orderMaster;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public OrderMaster getOrderMaster() {
        return orderMaster;
    }

    public void setOrderMaster(OrderMaster orderMaster) {
        this.orderMaster = orderMaster;
    }
}
