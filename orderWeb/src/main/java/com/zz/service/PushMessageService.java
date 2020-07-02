package com.zz.service;

import com.zz.dto.OrderDTO;

/**
 * 推送消息
 * Created by Bsea
 * 2019-07-30 22:08
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
