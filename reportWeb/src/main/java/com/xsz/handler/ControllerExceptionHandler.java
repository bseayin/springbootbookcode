package com.xsz.handler;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/9/2$ 21:48$
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import com.xsz.excetion.UserNotExistException;
@ControllerAdvice
public class ControllerExceptionHandler {
    //返回json的错误信息
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistsException(UserNotExistException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", e.getId());
        map.put("message", e.getMessage());
        return map;
    }
    //错误以后，跳转到自己定义的错误页面
    @ExceptionHandler(ArithmeticException.class)
    public String handle1(ArithmeticException e) {
        System.out.println("handle1 500*到了**************");
        return "/500.html";
    }
}