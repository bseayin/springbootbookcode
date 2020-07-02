package com.zz.exception;

import com.zz.enums.ResultEnum;
import lombok.Getter;

/**
 * Created by Bsea
 * 2019-06-11 18:55
 */
@Getter
public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
