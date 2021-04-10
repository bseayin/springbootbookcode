package com.zz.shop.service;

import com.zz.shop.domain.ShopProductCommentDO;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.domain.ShopProductEpisodeDO;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shop.vo.CategoryWithProductVO;

import java.util.List;
import java.util.Map;

public interface ShopProductCommentService {
  List<ShopProductCommentDO> getProductComment(String productId);
  int getProductCommentCount(String productId);
  int getProductGoodCommentCount(String productId);
}
