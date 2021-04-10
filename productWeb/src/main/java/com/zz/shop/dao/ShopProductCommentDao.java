package com.zz.shop.dao;

import com.zz.shop.domain.ShopProductCommentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopProductCommentDao {
  List<ShopProductCommentDO> get_product_comment(String productId, int count);
  int get_product_comment_count(String productId);
  int get_product_good_comment_count(String productId);

}
