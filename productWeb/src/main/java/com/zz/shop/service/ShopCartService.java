package com.zz.shop.service;

import com.zz.shop.domain.ShopCartDO;
import com.zz.shop.domain.ShopCartWithProductInfo;

import java.util.List;

public interface ShopCartService {
  List<ShopCartWithProductInfo> getUserCartList(String userId);
  void addToCart(ShopCartDO cart);
  void deleteFromCart(ShopCartDO cart);
  void updateCartItemMount(String userId, String productId, int mount);
}
