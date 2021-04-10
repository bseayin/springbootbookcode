package com.zz.shop.vo;

import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shop.domain.ShopProductDO;

import java.io.Serializable;
import java.util.List;

public class CategoryWithProductVO implements Serializable {
  ShopProductCategoryDO productCategory;
  List<ShopProductDO> productList;

  public ShopProductCategoryDO getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(ShopProductCategoryDO productCategory) {
    this.productCategory = productCategory;
  }

  public List<ShopProductDO> getProductList() {
    return productList;
  }

  public void setProductList(List<ShopProductDO> productList) {
    this.productList = productList;
  }
}
