package com.zz.shop.dao;

import com.zz.shop.domain.ShopProductDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopProductDao {
  List<ShopProductDO> product_get_product_by_category(String categoryId, int count, int start);
  List<ShopProductDO> product_get_product_by_category_with_sold_count(String categoryId, int count, int start);
  int product_get_product_count_by_category(@Param("categoryId")String categoryId);
  ShopProductDO product_get_product_with_sold_count(String productId);
}
