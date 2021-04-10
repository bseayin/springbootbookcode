package com.zz.shop.dao;

import com.zz.shop.domain.ShopCarouselDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopUserBrowseProductHistoryDao {
  int get_product_browse_count(String productId);
}
