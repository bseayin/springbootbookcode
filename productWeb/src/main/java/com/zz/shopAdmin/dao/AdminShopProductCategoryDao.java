package com.zz.shopAdmin.dao;

import com.zz.schoolwall.domain.SchoolWallDO;
import com.zz.shop.domain.ShopProductCategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminShopProductCategoryDao {
  List<ShopProductCategoryDO> list(Map<String,Object> map);

  ShopProductCategoryDO get(String wallId);

  int count(Map<String,Object> map);
  int save(ShopProductCategoryDO record);
  int update(ShopProductCategoryDO record);
  int updateOldPid(String newPid,String oldPid);

  int remove(String wallId);
  int batchRemove(String[] wallIds);
}
