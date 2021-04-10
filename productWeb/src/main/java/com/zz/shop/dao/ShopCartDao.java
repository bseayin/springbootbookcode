package com.zz.shop.dao;

import com.zz.shop.domain.ShopCarouselDO;
import com.zz.shop.domain.ShopCartDO;
import com.zz.shop.domain.ShopCartWithProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopCartDao {
  List<ShopCartWithProductInfo> get_user_cart_list(String userId);
  void add_product_to_cart(ShopCartDO cart);
  void set_cart_item_mount(ShopCartDO cart);
  int get_user_product_count(ShopCartDO cart);
  void add_cart_item_mount(ShopCartDO cart);
  void delete_user_product_cart(ShopCartDO cart);
}
