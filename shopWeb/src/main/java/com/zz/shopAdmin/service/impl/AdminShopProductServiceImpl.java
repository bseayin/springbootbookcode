package com.zz.shopAdmin.service.impl;

import com.zz.common.utils.ShiroUtils;
import com.zz.common.utils.StringUtils;
import com.zz.shop.dao.ShopUserBrowseProductHistoryDao;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shopAdmin.dao.AdminShopProductDao;
import com.zz.shopAdmin.dao.AdminUserproductfavoriteDao;
import com.zz.shopAdmin.domain.ProductinproductcategoryDO;
import com.zz.shopAdmin.domain.ShopProductDTO;
import com.zz.shopAdmin.service.AdminProductinproductcategoryService;
import com.zz.shopAdmin.service.AdminShopProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AdminShopProductServiceImpl implements AdminShopProductService {
	@Autowired
	private AdminShopProductDao adminShopProductDao;
	@Autowired
	private AdminProductinproductcategoryService adminProductinproductcategoryService;
	@Autowired
	private ShopUserBrowseProductHistoryDao shopUserBrowseProductHistoryDao;
	@Autowired
	private AdminUserproductfavoriteDao adminUserproductfavoriteDao;

	@Override
	public ShopProductDO get(String id){
		return adminShopProductDao.get(id);
	}
	
	@Override
	public List<ShopProductDO> list(Map<String, Object> map){
		return adminShopProductDao.list(map);
	}

	@Override
	public List<ShopProductDTO> listSimple(Map<String, Object> map){
		List<ShopProductDTO> re=adminShopProductDao.listSimple(map);

		Map tt=new HashMap();
		tt.put("active",1);
		for(ShopProductDTO t:re){
			tt.put("productId",t.getId());
			t.setFavoriteNum(adminUserproductfavoriteDao.count(tt));
			t.setBrowseNum(shopUserBrowseProductHistoryDao.get_product_browse_count(t.getId()));
		}
		return re;
	}

	@Override
	public int count(Map<String, Object> map){
		return adminShopProductDao.count(map);
	}
	
	@Override
	public int save(ShopProductDO product){
		if(StringUtils.isBlank(product.getId())){
			product.setId(UUID.randomUUID().toString().replace("-", ""));
		}
		if(StringUtils.isBlank(product.getShopId())){
			product.setShopId(ShiroUtils.getUser().getDeptId()+"");
		}

		product.setUpdatedBy(ShiroUtils.getUserId()+"");
		product.setCreatedBy(ShiroUtils.getUserId()+"mj ");
		product.setUpdatedTime(new Date());
		return adminShopProductDao.save(product);
	}
	@Override
	public int save(ShopProductDTO product){
		product.setId(UUID.randomUUID().toString().replace("-", ""));
		String[] categorysIds=product.getCategoryIds();
		if(categorysIds!=null){
			String productId=product.getId();
			if(StringUtils.isNotBlank(productId)){
				adminProductinproductcategoryService.remove(productId);
			}
			for(String tempId:categorysIds){
				ProductinproductcategoryDO tempDo=new ProductinproductcategoryDO();
				tempDo.setProductId(productId);
				tempDo.setProductCategoryId(tempId);
				adminProductinproductcategoryService.save(tempDo);
			}
		}

		return save((ShopProductDO)product);
	}

	@Override
	public int update(ShopProductDO product){
		product.setUpdatedBy(ShiroUtils.getUserId()+"");
		return adminShopProductDao.update(product);
	}
	@Override
	public int update(ShopProductDTO product){
		String[] categorysIds=product.getCategoryIds();
		if(categorysIds!=null){
			String productId=product.getId();
			if(StringUtils.isNotBlank(productId)){
				adminProductinproductcategoryService.remove(productId);
			}
			for(String tempId:categorysIds){
				ProductinproductcategoryDO tempDo=new ProductinproductcategoryDO();
				tempDo.setProductId(productId);
				tempDo.setProductCategoryId(tempId);
				adminProductinproductcategoryService.save(tempDo);
			}
		}

		return update((ShopProductDO)product);
	}

	@Override
	public int updateActive(String id,Boolean active){
		ShopProductDO productDO=new ShopProductDO();
		productDO.setId(id);
		productDO.setActive(active);
		productDO.setUpdatedBy(ShiroUtils.getUserId()+"");
		return adminShopProductDao.updateActive(productDO);
	}

	@Override
	public int remove(String id){
		return adminShopProductDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return adminShopProductDao.batchRemove(ids);
	}
	
}
