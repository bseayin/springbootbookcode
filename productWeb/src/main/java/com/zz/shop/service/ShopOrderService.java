package com.zz.shop.service;

import com.zz.shop.domain.ShopCartDO;
import com.zz.shop.domain.ShopCartWithProductInfo;
import com.zz.shop.domain.ShopOrderDO;
import com.zz.shop.domain.ShopOrderWithProductInfo;

import java.util.List;
import java.util.Map;

public interface ShopOrderService {
  List<ShopOrderWithProductInfo> getUserOrderList(String userId);
  List<ShopOrderWithProductInfo> getUserOrderListBySetId(String userId, String setId);
  void addToOrder(List<String> cartIdList);
  List<ShopOrderWithProductInfo> orderNow(String userId, List<String> productIdList);
  List<ShopOrderWithProductInfo> addFromCart(String userId, String comments, List<String> cartIdList);
  void updateOrderStatusFromCreateToConfirmed(String orderSetId, String comments);
  List<ShopOrderWithProductInfo> getOrderListByOrderSetId(String userId, String orderSetId);
  Map<String, List<ShopOrderWithProductInfo>> getOrderGroupByOrderSet(String userId, int status, int from, int pageSize);
}
