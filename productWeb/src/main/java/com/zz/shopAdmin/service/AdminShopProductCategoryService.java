package com.zz.shopAdmin.service;

import com.zz.common.domain.Tree;
import com.zz.shop.domain.ShopCarouselDO;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.system.domain.MenuDO;

import java.util.List;
import java.util.Map;

public interface AdminShopProductCategoryService {



  List<ShopProductCategoryDO> list(Map<String,Object> map);
  List<ShopProductCategoryDO> listActive(Map<String,Object> map);

  ShopProductCategoryDO get(String id);

  int count(Map<String,Object> map);
  int save(ShopProductCategoryDO record);
  int update(ShopProductCategoryDO record);

  int remove(String id);
  int batchRemove(String[] ids);
  Tree<MenuDO> getTree(String id);
}
