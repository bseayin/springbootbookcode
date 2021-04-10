package com.zz.wechatshop.service;

import com.zz.shop.domain.ShopProductDO;
import com.zz.wechatshop.vo.ProductBaseInfo;

import java.util.List;
import java.util.Map;

public interface ShopProductService {
  public ShopProductDO get(String id);
  public Map<String,Object> getProductInfo(String id);
  public List<ProductBaseInfo>  listSimple(Map<String, Object> map);
}
