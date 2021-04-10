package com.zz.shop.service.impl;

import com.zz.shop.dao.ShopProductCategoryDao;
import com.zz.shop.dao.ShopProductCommentDao;
import com.zz.shop.dao.ShopProductDao;
import com.zz.shop.dao.ShopProductEpisodeDao;
import com.zz.shop.dao.ShopProductImageDao;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shop.domain.ShopProductCommentDO;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.domain.ShopProductEpisodeDO;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shop.service.ShopProductCommentService;
import com.zz.shop.service.ShopProductService;
import com.zz.shop.vo.CategoryWithProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopProductCommentServiceImpl implements ShopProductCommentService {

  @Autowired
  ShopProductCommentDao commentDao;
  @Override
  public List<ShopProductCommentDO> getProductComment(String productId) {
    return commentDao.get_product_comment(productId, 8);
  }

  @Override
  public int getProductCommentCount(String productId) {
    return commentDao.get_product_comment_count(productId);
  }

  @Override
  public int getProductGoodCommentCount(String productId) {
    return commentDao.get_product_good_comment_count(productId);
  }
}
