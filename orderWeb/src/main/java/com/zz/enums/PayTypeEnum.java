package com.zz.enums;

import lombok.Getter;

/**
 * Created by Bsea
 * 2019-06-11 17:16
 */
@Getter
public enum PayTypeEnum implements CodeEnum {

    WECHATPAY(0, "微信支付"),
    SCOREPAY(1, "积分支付"),
    ALIPAY(2, "支付宝支付"),
    CASHPAY(3, "现金支付"),
    ;

    private Integer code;

    private String message;

    PayTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
