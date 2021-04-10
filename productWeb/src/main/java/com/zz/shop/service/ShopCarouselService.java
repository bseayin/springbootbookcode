package com.zz.shop.service;

import com.zz.shop.domain.ShopCarouselDO;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.vo.CategoryWithProductVO;

import java.util.List;

public interface ShopCarouselService {
  List<ShopCarouselDO> getHomepageCarousel();
}
