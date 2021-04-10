package com.zz.shopAdmin.service;

import com.zz.shopAdmin.domain.ProductinproductcategoryDO;

import java.util.List;
import java.util.Map;

/**
 * 产品类别
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-28 22:01:10
 */
public interface AdminProductinproductcategoryService {
	
	ProductinproductcategoryDO get(String productid);
	
	List<ProductinproductcategoryDO> list(Map<String, Object> map);
	List<ProductinproductcategoryDO> list(String productId);

	int count(Map<String, Object> map);
	
	int save(ProductinproductcategoryDO productinproductcategory);
	
	int update(ProductinproductcategoryDO productinproductcategory);
	
	int remove(String productid);
	
	int batchRemove(String[] productids);
}
