package com.zz.shop.dao;

import com.zz.shop.domain.ShopProductImageDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopProductImageDao {
  List<ShopProductImageDO> get_product_image(String productId);
}
