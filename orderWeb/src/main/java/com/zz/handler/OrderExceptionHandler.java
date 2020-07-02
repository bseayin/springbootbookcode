package com.zz.handler;

import com.zz.VO.ResultVO;
import com.zz.config.ProjectUrlConfig;
import com.zz.exception.OrderException;
import com.zz.exception.ResponseBankException;
import com.zz.exception.SellException;
import com.zz.exception.SellerAuthorizeException;
import com.zz.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Bsea
 * 2019-07-30 17:44
 */
@ControllerAdvice
public class OrderExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;


    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = OrderException.class)
    @ResponseBody
    public ResultVO handlerSellerException(OrderException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException() {

    }
}
