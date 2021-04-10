package com.zz.shopAdmin.dao;


import java.util.List;
import java.util.Map;

import com.zz.shop.domain.ShopProductDO;
import com.zz.shopAdmin.domain.ShopProductDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-26 16:18:25
 */
@Mapper
public interface AdminShopProductDao {

	ShopProductDO get(String id);
	
	List<ShopProductDO> list(Map<String,Object> map);
	List<ShopProductDTO> listSimple(Map<String,Object> map);

	int count(Map<String,Object> map);
	
	int save(ShopProductDO product);
	
	int update(ShopProductDO product);

	int updateActive(ShopProductDO product);

	int remove(String id);
	
	int batchRemove(String[] ids);
}
