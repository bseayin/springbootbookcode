package com.xsz.excetion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobExceptionHandler {
    //没有匹配的错误处理方法的时候，就被这个处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handle2(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        log.error(e.getMessage());
        return map;
    }
}
