package com.zz.shopAdmin.dao;

import com.zz.shopAdmin.domain.ProductinproductcategoryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 产品类别
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-28 22:01:10
 */
@Mapper
public interface AdminProductinproductcategoryDao {

	ProductinproductcategoryDO get(String productid);
	
	List<ProductinproductcategoryDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProductinproductcategoryDO productinproductcategory);
	
	int update(ProductinproductcategoryDO productinproductcategory);
	
	int remove(String productId);
	
	int batchRemove(String[] productids);
}
