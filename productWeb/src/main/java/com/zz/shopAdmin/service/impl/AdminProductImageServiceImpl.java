package com.zz.shopAdmin.service.impl;

import com.zz.common.utils.ShiroUtils;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shopAdmin.dao.AdminProductImageDao;
import com.zz.shopAdmin.dao.AdminShopProductDao;
import com.zz.shopAdmin.service.AdminProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class AdminProductImageServiceImpl implements AdminProductImageService {
	@Autowired
	private AdminProductImageDao productimageDao;
	
	@Override
	public ShopProductImageDO get(String id){
		return productimageDao.get(id);
	}
	
	@Override
	public List<ShopProductImageDO> list(Map<String, Object> map){
		return productimageDao.list(map);
	}
	@Override
	public List<ShopProductImageDO> list(String productId){
		Map map=new HashMap();
		map.put("productId",productId);
		return list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return productimageDao.count(map);
	}
	
	@Override
	public int save(ShopProductImageDO productimage){
		productimage.setId(UUID.randomUUID().toString().replace("-", ""));
		productimage.setCreatedBy(ShiroUtils.getUserId()+"");
		productimage.setUpdatedBy(ShiroUtils.getUserId()+"");
		return productimageDao.save(productimage);
	}
	
	@Override
	public int update(ShopProductImageDO productimage){
		productimage.setUpdatedBy(ShiroUtils.getUserId()+"");
		return productimageDao.update(productimage);
	}

	@Override
	public int updateActive(String id,Boolean active){
		ShopProductImageDO productimage=new ShopProductImageDO();
		productimage.setId(id);
		productimage.setActive(active);
		productimage.setUpdatedBy(ShiroUtils.getUserId()+"");
		return productimageDao.updateActive(productimage);
	}
	@Override
	public int remove(String id){
		return productimageDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return productimageDao.batchRemove(ids);
	}
	
}
