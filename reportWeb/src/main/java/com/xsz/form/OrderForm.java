package com.xsz.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Bsea
 * 2017-06-18 23:31
 */
@Data
public class OrderForm {

    /**
     * 买家手机号码
     */
    @NotEmpty(message = "手机号码必填")
    private String shopOrderCode;

    /**
     * 桌号
     */
    @NotEmpty(message = "桌号必填")
    private String shopOrderRemarks;

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String shopOrderUser;

    /**
     * 总价
     */

    private String shopOrderTotalprice;

    /**
     * 订单状态
     */

    private Byte shopOrderStatus;
    /**
     * 订单内容
     */
    private String shopOrderName;
    /**
     * 商户id
     */
    @NotEmpty(message = "商户号码必填")
    private String shopOrderCompanyid;
    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String shopRecordList;
}
