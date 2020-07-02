package com.zz.service;

import com.zz.dto.OrderDTO;
import com.zz.entity.OrderDetail;
import com.zz.entity.OrderMaster;
import com.zz.entity.ProductInfo;
import com.zz.enums.OrderStatusEnum;
import com.zz.enums.PayStatusEnum;
import com.zz.enums.ResultEnum;
import com.zz.exception.SellException;
import com.zz.form.OrderForm;
import com.zz.repository.OrderDetailRepository;
import com.zz.repository.OrderMasterRepository;
import com.zz.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bsea
 * 2019-06-11 18:43
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Transactional
    public OrderMaster create(OrderForm orderForm) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        Set<OrderDetail> orderDetailSet =new HashSet<OrderDetail>();
        //1. 查询商品（数量, 价格）
        for (OrderDetail orderDetail: orderForm.getOrderDetailSet()) {
            ProductInfo productInfo =  productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//                throw new ResponseBankException();
            }

            //2. 计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailSet.add(orderDetail);

        }
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderForm, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderDetailSet(orderDetailSet);
        orderMasterRepository.save(orderMaster);
        return orderMaster;
    }


    public OrderMaster findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).orElse(null);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderMaster;
    }

    public OrderDetail findDetail(String orderDetailId) {
        OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElse(null);
        if (orderDetail == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderDetail;
    }

    public Page<OrderMaster> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        return orderMasterPage;
    }


    @Transactional
    public OrderMaster cancel(String  orderId) {
        OrderMaster orderMaster = new OrderMaster();
        //修改订单状态
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        orderMaster.setOrderId(orderId);

        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("【取消订单】更新失败, orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return updateResult;
    }


    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【完结订单】订单状态不正确, orderId={}, orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("【完结订单】更新失败, orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }



        return orderDTO;
    }

    public Page<OrderMaster> findList(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findAll(pageable);
        return orderMasterPage;
    }
}
