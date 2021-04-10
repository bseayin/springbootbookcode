package com.zz.shopAdmin.service.impl;

import com.zz.common.utils.ShiroUtils;
import com.zz.shopAdmin.dao.AdminProductinproductcategoryDao;
import com.zz.shopAdmin.service.AdminProductinproductcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zz.shopAdmin.domain.ProductinproductcategoryDO;



@Service
public class AdminProductinproductcategoryServiceImpl implements AdminProductinproductcategoryService {
	@Autowired
	private AdminProductinproductcategoryDao productinproductcategoryDao;
	
	@Override
	public ProductinproductcategoryDO get(String productid){
		return productinproductcategoryDao.get(productid);
	}
	
	@Override
	public List<ProductinproductcategoryDO> list(Map<String, Object> map){
		return productinproductcategoryDao.list(map);
	}
	@Override
	public List<ProductinproductcategoryDO> list(String productId){
		Map map=new HashMap();
		map.put("productId",productId);
		return list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return productinproductcategoryDao.count(map);
	}
	
	@Override
	public int save(ProductinproductcategoryDO productinproductcategory){
		String userId=ShiroUtils.getUserId()+"";
		productinproductcategory.setCreatedBy(userId);
		productinproductcategory.setUpdatedBy(userId);
		return productinproductcategoryDao.save(productinproductcategory);
	}
	
	@Override
	public int update(ProductinproductcategoryDO productinproductcategory){
		productinproductcategory.setUpdatedBy(ShiroUtils.getUserId()+"");
		return productinproductcategoryDao.update(productinproductcategory);
	}
	
	@Override
	public int remove(String productid){
		return productinproductcategoryDao.remove(productid);
	}
	
	@Override
	public int batchRemove(String[] productids){
		return productinproductcategoryDao.batchRemove(productids);
	}
	
}
