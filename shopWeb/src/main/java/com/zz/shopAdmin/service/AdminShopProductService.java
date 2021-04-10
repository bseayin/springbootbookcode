package com.zz.shopAdmin.service;


import com.zz.shop.domain.ShopProductDO;
import com.zz.shopAdmin.domain.ShopProductDTO;

import java.util.List;
import java.util.Map;

/**
 * 产品
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-26 16:18:25
 */
public interface AdminShopProductService {
	
	ShopProductDO get(String id);
	
	List<ShopProductDO> list(Map<String, Object> map);
	List<ShopProductDTO> listSimple(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(ShopProductDO product);
	int save(ShopProductDTO product);

	int update(ShopProductDO product);
	int update(ShopProductDTO product);
	int updateActive(String id,Boolean active);

	int remove(String id);
	
	int batchRemove(String[] ids);


}
