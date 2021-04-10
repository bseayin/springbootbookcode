package com.zz.shop.dao;

import com.zz.shop.domain.ShopProductCategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopProductCategoryDao {
  List<ShopProductCategoryDO> get_main_page_category();
  List<ShopProductCategoryDO> get_child_category_list(int count);
  List<ShopProductCategoryDO> get_all_category_list();
  List<ShopProductCategoryDO> get_top_level_category_list();

}
