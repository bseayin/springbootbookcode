package com.zz.shop.service;

import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.domain.ShopProductEpisodeDO;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shop.vo.CategoryWithProductVO;

import java.util.List;
import java.util.Map;

public interface ShopProductService {
  List<ShopProductDO> getProductByCategory(String categoryId, int count);
  Map<String, Object> getProductByCategory(String categoryId, int count, int start);
  List<CategoryWithProductVO> getProductByCategoryList(int categoryCount, int productInEachCategoryCount);
  List<ShopProductImageDO> getProductCarouselImage(String productId);
  ShopProductDO getProductDetail(String productId);
  Map<String, List<ShopProductEpisodeDO>> getProductEpisode(String productId);
  int getProductBrowseCount(String productId);
  void updateUserProductFavor(String productId, String userId, boolean isFavor);
  boolean isUserFavorTheProduct(String productId, String userId);
  void populateProductImage(List<ShopProductDO> products);
}
