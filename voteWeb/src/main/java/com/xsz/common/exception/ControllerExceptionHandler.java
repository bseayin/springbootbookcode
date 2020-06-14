package com.xsz.common.exception;

import com.xsz.common.domain.ResponseBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author llf
 * @description:统一异常处理
 * @date 2020/5/29
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBo NotFindException(NullPointerException e) {
        return ResponseBo.failure(404,"找不到相关信息---"+e.getMessage());
    }

    @ExceptionHandler(ParseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBo ParseException(ParseException e) {
        log.error("日期或者字符串格式化异常",e);
        return ResponseBo.error(e.getMessage());
    }

}

