package com.zz.shop.service.impl;

import com.zz.shop.dao.ShopProductCategoryDao;
import com.zz.shop.dao.ShopProductDao;
import com.zz.shop.dao.ShopProductEpisodeDao;
import com.zz.shop.dao.ShopProductImageDao;
import com.zz.shop.dao.ShopUserBrowseProductHistoryDao;
import com.zz.shop.dao.ShopUserProductFavoriteDao;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.domain.ShopProductEpisodeDO;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shop.service.ShopProductService;
import com.zz.shop.vo.CategoryWithProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShopProductServiceImpl implements ShopProductService {
  @Autowired
  ShopProductDao productDao;

  @Autowired
  ShopProductCategoryDao productCategoryDao;

  @Autowired
  ShopProductImageDao productImageDao;

  @Autowired
  ShopProductEpisodeDao episodeDao;

  @Autowired
  ShopUserBrowseProductHistoryDao browseProductHistoryDao;

  @Autowired
  ShopUserProductFavoriteDao favoriteDao;

  @Value("${ImageHost}")
  String imageHost;

  @Override
  public List<ShopProductDO> getProductByCategory(String categoryId, int count) {
    List<ShopProductDO> list =  productDao.product_get_product_by_category(categoryId, count, 0);
    this.populateProductImage(list);
    return list;
  }

  @Override
  public Map<String, Object> getProductByCategory(String categoryId, int count, int start) {
    List<ShopProductDO> productList = productDao.product_get_product_by_category_with_sold_count(categoryId, count, start);
    populateProductImage(productList);
    int totalCount = productDao.product_get_product_count_by_category(categoryId);

    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("productList", productList);
    resultMap.put("hasNext", (start + count >= totalCount));
    return resultMap;
  }

  @Override
  public List<CategoryWithProductVO> getProductByCategoryList(int categoryCount, int productInEachCategoryCount) {
    List<CategoryWithProductVO> categoryWithProductVOList = new ArrayList<>();
    List<ShopProductCategoryDO> categoryList = productCategoryDao.get_child_category_list(categoryCount);
    List<ShopProductCategoryDO> selectedCategoryList = categoryList.subList(0, categoryCount).stream().map( item -> {
      item.setPicture(imageHost + item.getPicture());
      return item;
    }).collect(Collectors.toList());
    selectedCategoryList.forEach(category -> {
      CategoryWithProductVO vo = new CategoryWithProductVO();
      vo.setProductCategory(category);
      String categoryId = category.getId();
      List<ShopProductDO> productList = productDao.product_get_product_by_category(categoryId, productInEachCategoryCount, 0);
      this.populateProductImage(productList);
      vo.setProductList(productList);
      categoryWithProductVOList.add(vo);
    });
    return categoryWithProductVOList;
  }

  @Override
  public List<ShopProductImageDO> getProductCarouselImage(String productId) {
    return productImageDao.get_product_image(productId).stream().map( item -> {
      item.setImageSrc(imageHost + item.getImageSrc());
      return item;
    }).collect(Collectors.toList());
  }

  @Override
  public ShopProductDO getProductDetail(String productId) {
    ShopProductDO productDO = productDao.product_get_product_with_sold_count(productId);
    List<ShopProductDO> list = Arrays.asList(productDO);
    this.populateProductImage(list);
    return productDO;
  }

  @Override
  public Map<String, List<ShopProductEpisodeDO>> getProductEpisode(String productId) {
    List<ShopProductEpisodeDO> epList = episodeDao.get_by_product(productId);
    Map<String, List<ShopProductEpisodeDO>> epMap = new HashMap<>();
    for (ShopProductEpisodeDO ep : epList) {
      String category = ep.getCategory();
      if (!epMap.containsKey(category)) {
        epMap.put(category, new ArrayList<>());
      }
      epMap.get(category).add(ep);
    }
    return epMap;
  }

  @Override
  public int getProductBrowseCount(String productId) {
    return browseProductHistoryDao.get_product_browse_count(productId);
  }

  @Override
  public void updateUserProductFavor(String productId, String userId, boolean isFavor) {
    if (isFavor) {
      favoriteDao.add_favorite_product(productId, userId);
    } else {
      favoriteDao.un_favorite_product(productId, userId);
    }
  }

  @Override
  public boolean isUserFavorTheProduct(String productId, String userId) {
    return favoriteDao.get_user_product_favorite(productId, userId) > 0;
  }

  @Override
  public void populateProductImage(List<ShopProductDO> products) {
    for (ShopProductDO product : products) {
      List<ShopProductImageDO> carousels = this.getProductCarouselImage(product.getId());
      if (carousels != null && carousels.size() > 0) {
        product.setImage(carousels.get(0).getImageSrc());
      }
    }
  }
}
