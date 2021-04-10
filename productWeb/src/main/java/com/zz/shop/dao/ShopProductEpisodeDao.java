package com.zz.shop.dao;

import com.zz.shop.domain.ShopProductEpisodeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopProductEpisodeDao {
  List<ShopProductEpisodeDO> get_by_product(String productId);
}
