package com.zz.config;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/9/2$ 21:48$
 */

import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.NonUniqueResultException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    //返回json的错误信息
    @ExceptionHandler(NonUniqueResultException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleNonUniqueResultException(NonUniqueResultException e) {
        return ResultVOUtil.error(500,e.getMessage());
    }

    @ExceptionHandler(DataValidationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleDataValidationException(DataValidationException e) {
        return ResultVOUtil.error(500,"输入数据验证错误--"+e.getMessage());
    }

}



