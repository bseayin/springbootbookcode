package com.zz.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by Bsea
 * 2017-05-12 14:13
 */
@Data
public class ResultVO<T> {

    /** 结果. */
    private boolean success;

    /** 错误码. */
    private Integer errorCode;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T body;
}
