package com.zz.shopAdmin.service.impl;


import com.zz.shop.dao.ShopUserBrowseProductHistoryDao;
import com.zz.shopAdmin.service.AdminUserBrowseProductHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 产品
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-26 16:18:25
 */
public  class AdminUserBrowseProductHistoryServiceImp implements AdminUserBrowseProductHistoryService {
	@Autowired
	ShopUserBrowseProductHistoryDao shopUserBrowseProductHistoryDao;
	@Override
	public int count(String productId){
		return shopUserBrowseProductHistoryDao.get_product_browse_count(productId);
	}
}
