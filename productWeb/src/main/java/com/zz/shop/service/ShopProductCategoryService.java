package com.zz.shop.service;

import com.zz.shop.domain.ShopCarouselDO;
import com.zz.shop.domain.ShopProductCategoryDO;

import java.util.List;
import java.util.Map;

public interface ShopProductCategoryService {
  public List<ShopProductCategoryDO> getMainPageCategory();
  public List<ShopCarouselDO> getMainPageCarousel();
  public List<ShopProductCategoryDO> getLatestCategoryList(int count);
  public List<ShopProductCategoryDO> getAllCategoryList();
  public List<ShopProductCategoryDO> getTopLevelCategoryList();
  public Map<ShopProductCategoryDO, List<ShopProductCategoryDO>> getCategoryMap();
}
