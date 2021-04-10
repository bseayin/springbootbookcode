package com.zz.shop.service.impl;

import com.zz.shop.dao.ShopOrderDao;
import com.zz.shop.domain.ShopOrderDO;
import com.zz.shop.domain.ShopOrderWithProductInfo;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shop.service.ShopOrderService;
import com.zz.shop.service.ShopProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

  @Autowired
  ShopOrderDao shopOrderDao;

  @Autowired
  ShopProductService shopProductService;

  @Override
  public List<ShopOrderWithProductInfo> getUserOrderList(String userId) {
    return shopOrderDao.get_user_order_list(userId);
  }

  @Override
  public List<ShopOrderWithProductInfo> getUserOrderListBySetId(String userId, String setId) {
    return shopOrderDao.get_user_order_list_by_order_setid(userId, setId);
  }

  @Override
  public void addToOrder(List<String> cartIdList) {
    ShopOrderDO order = new ShopOrderDO();
    shopOrderDao.add_product_to_order(order);
  }

  @Override
  public List<ShopOrderWithProductInfo> orderNow(String userID, List<String> productIdList) {
    String setId = UUID.randomUUID().toString();
    for (String productId: productIdList) {
      ShopProductDO product = shopProductService.getProductDetail(productId);
      ShopOrderDO order = new ShopOrderDO();
      order.setId(UUID.randomUUID().toString());
      order.setOrderSetId(setId);
      order.setMount(1);
      float price = product.getSales();
      if (price == 0) {
        price = product.getPrice();
      }
      order.setStatus(1);
      order.setPrice(price);
      order.setProductId(productId);
      order.setUserId(userID);
      order.setCreatedBy(userID);
      order.setUpdatedBy(userID);
      shopOrderDao.add_product_to_order(order);
    }

    return this.getOrderListByOrderSetId(userID, setId);
  }

  @Override
  public List<ShopOrderWithProductInfo> addFromCart(String userId, String comments, List<String> cartIdList) {
    String uuid = UUID.randomUUID().toString();
    Map<String, Object> paramters = new HashMap<>();
    paramters.put("orderSetId", uuid);
    paramters.put("userId", userId);
    paramters.put("comments", comments);
    paramters.put("cartIdList", cartIdList);
    shopOrderDao.add_product_from_cart(paramters);

    return shopOrderDao.get_user_order_list_by_order_setid(userId, uuid);
  }

  @Override
  public void updateOrderStatusFromCreateToConfirmed(String orderSetId, String comments) {
    shopOrderDao.change_orderset_status(2, comments, orderSetId, 1);
  }

  @Override
  public List<ShopOrderWithProductInfo> getOrderListByOrderSetId(String userId, String orderSetId) {
    return shopOrderDao.get_user_order_list_by_order_setid(userId, orderSetId);
  }

  @Override
  public Map<String, List<ShopOrderWithProductInfo>> getOrderGroupByOrderSet(String userId, int status, int from, int pageSize) {
    Map<String, List<ShopOrderWithProductInfo>> orderGroupByOrderSet = new HashMap<>();
    List<String> orderSetList = shopOrderDao.get_user_orderSets(userId, status, from, pageSize);
    for (String orderSetId: orderSetList) {
      List<ShopOrderWithProductInfo> orderList = shopOrderDao.get_user_order_list_by_order_setid(userId, orderSetId);
      populateProductImage(orderList);
      orderGroupByOrderSet.put(orderSetId, orderList);
    }
    return orderGroupByOrderSet;
  }

  protected void populateProductImage(List<ShopOrderWithProductInfo> products) {
    for (ShopOrderWithProductInfo product : products) {
      List<ShopProductImageDO> carousels = shopProductService.getProductCarouselImage(product.getProductId());
      if (carousels != null && carousels.size() > 0) {
        product.setImage(carousels.get(0).getImageSrc());
      }
    }
  }
}
