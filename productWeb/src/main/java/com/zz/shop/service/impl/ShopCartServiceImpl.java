package com.zz.shop.service.impl;

import com.zz.shop.dao.ShopCartDao;
import com.zz.shop.domain.ShopCartDO;
import com.zz.shop.domain.ShopCartWithProductInfo;
import com.zz.shop.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {
  @Autowired
  ShopCartDao shopCartDao;

  @Override
  public List<ShopCartWithProductInfo> getUserCartList(String userId) {
    return shopCartDao.get_user_cart_list(userId);
  }

  @Override
  public void addToCart(ShopCartDO cart) {
    if (shopCartDao.get_user_product_count(cart) > 0) {
      shopCartDao.add_cart_item_mount(cart);
    } else {
      shopCartDao.add_product_to_cart(cart);
    }
  }

  @Override
  public void deleteFromCart(ShopCartDO cart) {
    shopCartDao.delete_user_product_cart(cart);
  }

  @Override
  public void updateCartItemMount(String userId, String productId, int mount) {
    ShopCartDO cart = new ShopCartDO();
    cart.setUserId(userId);
    cart.setProductId(productId);
    cart.setMount(mount);
    shopCartDao.set_cart_item_mount(cart);
  }
}
