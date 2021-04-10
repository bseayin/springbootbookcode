package com.zz.shopAdmin.service;

import com.zz.shopAdmin.domain.AdminShopProductorderDO;
import com.zz.shopAdmin.domain.AdminShopProductorderVO;

import java.util.List;
import java.util.Map;

/**
 * 订单
 * 
 * @author jwh
 * @email jinwenhao
 * @date 2020-12-15 17:09:46
 */
public interface AdminShopProductorderService {
	
	AdminShopProductorderDO get(String id);
	
	List<AdminShopProductorderDO> list(Map<String, Object> map);
	List<AdminShopProductorderDO> listOrder(Map<String, Object> map);
	List<AdminShopProductorderVO> listProduct(Map<String, Object> map);

	int count(Map<String, Object> map);
	int countOrder(Map<String, Object> map);

	int save(AdminShopProductorderDO shopProductorder);
	
	int update(AdminShopProductorderDO shopProductorder);
	int updateByOrderSetId(AdminShopProductorderDO shopProductorder);

	int remove(String id);
	
	int batchRemove(String[] ids);
}
