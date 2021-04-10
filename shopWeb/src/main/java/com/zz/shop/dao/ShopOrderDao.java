package com.zz.shop.dao;

import com.zz.shop.domain.ShopOrderDO;
import com.zz.shop.domain.ShopOrderWithProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopOrderDao {
  void add_product_to_order(ShopOrderDO shopOrder);
  List<ShopOrderWithProductInfo> get_user_order_list(String userId);
  List<ShopOrderWithProductInfo> get_user_order_list_by_order_setid(String userId, String orderSetId);
  void add_product_from_cart(Map<String, Object> parameter);
  void change_orderset_status(int status, String comments, String orderSetId, int fromStatus);
  List<String> get_user_orderSets(String userId, int status, int from, int pageSize); // from 0
}
