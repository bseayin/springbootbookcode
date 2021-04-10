package com.zz.shopAdmin.service.impl;


import com.zz.shop.dao.ShopUserBrowseProductHistoryDao;
import com.zz.shopAdmin.dao.AdminUserproductfavoriteDao;
import com.zz.shopAdmin.service.AdminUserBrowseProductHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 产品
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-26 16:18:25
 */
public  class AdminProductFavoriteServiceImp implements AdminUserBrowseProductHistoryService {
	@Autowired
	AdminUserproductfavoriteDao adminUserproductfavoriteDao;
	@Override
	public int count(String productId){
		Map t=new HashMap();
		t.put("productId",productId);
		t.put("active",1);
		return adminUserproductfavoriteDao.count(t);
	}
}
