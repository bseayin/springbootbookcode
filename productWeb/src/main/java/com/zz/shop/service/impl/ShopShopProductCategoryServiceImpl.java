package com.zz.shop.service.impl;

import com.zz.shop.dao.ShopCarouselDao;
import com.zz.shop.dao.ShopProductCategoryDao;
import com.zz.shop.domain.ShopCarouselDO;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shop.service.ShopProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShopShopProductCategoryServiceImpl implements ShopProductCategoryService {
  @Autowired
  ShopProductCategoryDao productCategoryDao;
  @Autowired
  ShopCarouselDao carouselDao;

  @Value("${ImageHost}")
  String imageHost;

  @Override
  public List<ShopProductCategoryDO> getMainPageCategory() {
    return productCategoryDao.get_main_page_category().stream().map((item) -> {
      String icon = item.getIcon();
      item.setIcon(imageHost + icon);
      String picture = item.getPicture();
      item.setPicture(imageHost + picture);
      return item;
    }).collect(Collectors.toList());
  }

  @Override
  public List<ShopCarouselDO> getMainPageCarousel() {
    return carouselDao.get_homepage_carousel().stream().map((item) -> {
      String src = item.getSrc();
      item.setSrc(imageHost + src);
      return item;
    }).collect(Collectors.toList());
  }

  @Override
  public List<ShopProductCategoryDO> getLatestCategoryList(int count) {
    return productCategoryDao.get_child_category_list(count).stream().map((item) -> {
      String icon = item.getIcon();
      item.setIcon(imageHost + icon);
      String picture = item.getPicture();
      item.setPicture(imageHost + picture);
      return item;
    }).collect(Collectors.toList());
  }

  @Override
  public List<ShopProductCategoryDO> getAllCategoryList() {
    return productCategoryDao.get_all_category_list().stream().map((item) -> {
      String icon = item.getIcon();
      item.setIcon(imageHost + icon);
      String picture = item.getPicture();
      item.setPicture(imageHost + picture);
      return item;
    }).collect(Collectors.toList());
  }

  @Override
  public List<ShopProductCategoryDO> getTopLevelCategoryList() {
    return productCategoryDao.get_top_level_category_list().stream().map((item) -> {
      String icon = item.getIcon();
      item.setIcon(imageHost + icon);
      String picture = item.getPicture();
      item.setPicture(imageHost + picture);
      return item;
    }).collect(Collectors.toList());
  }

  @Override
  public Map<ShopProductCategoryDO, List<ShopProductCategoryDO>> getCategoryMap() {
    List<ShopProductCategoryDO> allCategory = productCategoryDao.get_all_category_list().stream().map((item) -> {
      String icon = item.getIcon();
      item.setIcon(imageHost + icon);
      String picture = item.getPicture();
      item.setPicture(imageHost + picture);
      return item;
    }).collect(Collectors.toList());;
    Map<String, List<ShopProductCategoryDO>> categoryMap = new HashMap<>();
    List<ShopProductCategoryDO> topLevelCategoryList = productCategoryDao.get_top_level_category_list().stream().map((item) -> {
      String icon = item.getIcon();
      item.setIcon(imageHost + icon);
      String picture = item.getPicture();
      item.setPicture(imageHost + picture);
      return item;
    }).collect(Collectors.toList());;
    for (ShopProductCategoryDO category : allCategory) {
      String pid = category.getPid();
      if (!categoryMap.containsKey(pid)) {
        categoryMap.put("pid", new ArrayList<>());
      }
      categoryMap.get("pid").add(category);
    }
    Map<ShopProductCategoryDO, List<ShopProductCategoryDO>> resultMap = new HashMap<>();
    for (ShopProductCategoryDO category : topLevelCategoryList) {
      List<ShopProductCategoryDO> subCategoryList = categoryMap.get(category.getId());
      if (subCategoryList == null) {
        subCategoryList = new ArrayList<>();
      }
      resultMap.put(category, subCategoryList);
    }
    return resultMap;
  }
}
