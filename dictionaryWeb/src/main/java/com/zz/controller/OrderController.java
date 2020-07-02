package com.zz.controller;
/**
 * @Description:  订单控制类
 * @Author: Bsea
 * @CreateDate: 2019/9/25
 */
import com.zz.entity.OrderMaster;
import com.zz.service.OrderService;
import com.zz.util.KeyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Api(value = "订单Controller")
@RestController
@RequestMapping("order")
public class OrderController {
	@Resource
    OrderService orderService;

	@ApiOperation(value = "查订单", notes = "根据id查订单")
	@ApiImplicitParam(name = "id", value = "订单id", required = true, dataType = "String",paramType = "path")
	@GetMapping("show/{id}")
	public OrderMaster getById(@PathVariable("id") String id){
		return orderService.getById(id);
	}

}
