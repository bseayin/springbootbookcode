package com.zz.enums;

import lombok.Getter;

/**
 * Created by Bsea
 * 2019-06-11 17:16
 */
@Getter
public enum PrintStatusEnum implements CodeEnum {

    WAIT(0, "等待打印"),
    SUCCESS(1, "打印成功"),

    ;

    private Integer code;

    private String message;

    PrintStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
