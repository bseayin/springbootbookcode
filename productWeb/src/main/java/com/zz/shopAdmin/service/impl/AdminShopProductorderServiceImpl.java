package com.zz.shopAdmin.service.impl;

import com.zz.shop.domain.ShopProductDO;
import com.zz.shopAdmin.dao.AdminShopProductDao;
import com.zz.shopAdmin.dao.AdminShopProductorderDao;
import com.zz.shopAdmin.domain.AdminShopProductorderDO;
import com.zz.shopAdmin.domain.AdminShopProductorderVO;
import com.zz.shopAdmin.service.AdminShopProductorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Service
public class AdminShopProductorderServiceImpl implements AdminShopProductorderService {
	@Autowired
	private AdminShopProductorderDao shopProductorderDao;
	@Autowired
	private AdminShopProductDao shopProductDao;

	@Override
	public AdminShopProductorderDO get(String id){
		return shopProductorderDao.get(id);
	}
	
	@Override
	public List<AdminShopProductorderDO> list(Map<String, Object> map){
		return shopProductorderDao.list(map);
	}

	@Override
	public List<AdminShopProductorderVO> listProduct(Map<String, Object> map){

		return shopProductorderDao.listProduct(map);
	}
	@Override
	public List<AdminShopProductorderDO> listOrder(Map<String, Object> map){
		List<AdminShopProductorderDO> re=shopProductorderDao.listOrder(map);
		for(AdminShopProductorderDO t:re){
			Map tempMap=new HashMap();
			tempMap.put("ordersetid",t.getOrdersetid());
			List<AdminShopProductorderVO> tproductList=listProduct(tempMap);
			BigDecimal totalprice=new BigDecimal(0);
			for(AdminShopProductorderVO tProduct:tproductList){
				if(tProduct.getSales()>0){
					totalprice=totalprice.add(new BigDecimal(tProduct.getProductorderMount()*tProduct.getSales()));
				}else{
					totalprice=totalprice.add(new BigDecimal(tProduct.getProductorderMount()*tProduct.getPrice()));
				}

			}
			t.setPrice(totalprice.floatValue());
		}
		return re;
	}
	@Override
	public int count(Map<String, Object> map){
		return shopProductorderDao.count(map);
	}
	@Override
	public int countOrder(Map<String, Object> map){
		return shopProductorderDao.countOrder(map);
	}

	@Override
	public int save(AdminShopProductorderDO shopProductorder){
		return shopProductorderDao.save(shopProductorder);
	}
	
	@Override
	public int update(AdminShopProductorderDO shopProductorder){
		return shopProductorderDao.update(shopProductorder);
	}
	@Override
	public int updateByOrderSetId(AdminShopProductorderDO shopProductorder){
		return shopProductorderDao.updateByOrderSetId(shopProductorder);
	}

	@Override
	public int remove(String id){
		return shopProductorderDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return shopProductorderDao.batchRemove(ids);
	}
	
}
