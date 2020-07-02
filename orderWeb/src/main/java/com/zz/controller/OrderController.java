package com.zz.controller;

import com.zz.VO.ResultVO;
import com.zz.dto.OrderDTO;
import com.zz.entity.OrderDetail;
import com.zz.entity.OrderMaster;
import com.zz.enums.ResultEnum;
import com.zz.exception.OrderException;
import com.zz.form.OrderForm;

import com.zz.service.OrderService;
import com.zz.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bsea
 * 2019-06-18 23:27
 */
@Api(value = "订单控制器")
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Autowired
//    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    @ApiOperation(value = "创建订单", notes = "创建订单")

    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }



        OrderMaster createResult = orderService.create(orderForm);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    @ApiOperation(value = "订单列表", notes = "分页订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openid", value = "用户微信唯一标识符", required = true, dataType = "String"),
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "一页显示记录", required = true, dataType = "Integer")
    })
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = PageRequest.of(page, size);
        Page<OrderMaster> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }


    //订单详情
    @GetMapping("/detail")
    @ApiOperation(value = "订单详情", notes = "订单详情")
    @ApiImplicitParams({

            @ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "String")
    })
    public ResultVO<OrderDetail> detail(@RequestParam("orderId") String orderId) {

        return ResultVOUtil.success(orderService.findDetail(orderId));
    }

    //取消订单
    @PostMapping("/cancel")
    @ApiOperation(value = "取消订单", notes = "取消订单")
    @ApiImplicitParams({

            @ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "String")
    })
    public ResultVO cancel(
                           @RequestParam("orderId") String orderId) {
        orderService.cancel(orderId);
        return ResultVOUtil.success();
    }
}
