package com.zz.shop.dao;

import com.zz.shop.domain.ShopCarouselDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopUserProductFavoriteDao {
  void add_favorite_product(String productId, String userId);
  void un_favorite_product(String productId, String userId);
  int get_user_product_favorite(String productId, String userId);
}
