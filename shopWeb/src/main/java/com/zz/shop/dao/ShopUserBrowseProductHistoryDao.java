package com.zz.shop.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopUserBrowseProductHistoryDao {
  int get_product_browse_count(String productId);
}
