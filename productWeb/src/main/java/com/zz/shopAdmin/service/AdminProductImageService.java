package com.zz.shopAdmin.service;

import com.zz.common.domain.Tree;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.system.domain.MenuDO;

import java.util.List;
import java.util.Map;

/**
 * 产品图片
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-27 17:08:34
 */
public interface AdminProductImageService {

	ShopProductImageDO get(String id);
	
	List<ShopProductImageDO> list(Map<String, Object> map);

	List<ShopProductImageDO> list(String productId);

	int count(Map<String, Object> map);
	
	int save(ShopProductImageDO productimage);
	
	int update(ShopProductImageDO productimage);

	int updateActive(String id,Boolean active);

	int remove(String id);
	
	int batchRemove(String[] ids);

}
