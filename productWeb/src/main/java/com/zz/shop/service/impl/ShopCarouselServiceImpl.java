package com.zz.shop.service.impl;

import com.zz.shop.dao.ShopCarouselDao;
import com.zz.shop.dao.ShopProductCategoryDao;
import com.zz.shop.dao.ShopProductDao;
import com.zz.shop.domain.ShopCarouselDO;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.service.ShopCarouselService;
import com.zz.shop.service.ShopProductService;
import com.zz.shop.vo.CategoryWithProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopCarouselServiceImpl implements ShopCarouselService {
  @Autowired
  ShopCarouselDao carouselDao;

  @Override
  public List<ShopCarouselDO> getHomepageCarousel() {
    return carouselDao.get_homepage_carousel();
  }
}
