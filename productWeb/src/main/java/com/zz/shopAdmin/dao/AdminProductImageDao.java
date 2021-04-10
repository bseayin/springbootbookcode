package com.zz.shopAdmin.dao;


import java.util.List;
import java.util.Map;

import com.zz.shop.domain.ShopProductImageDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品图片
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-27 17:08:34
 */
@Mapper
public interface AdminProductImageDao {

	ShopProductImageDO get(String id);
	
	List<ShopProductImageDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ShopProductImageDO productimage);
	
	int update(ShopProductImageDO productimage);

	int updateActive(ShopProductImageDO productimage);

	int remove(String id);
	
	int batchRemove(String[] ids);
}
