package com.zz.shop.domain;

public class ShopProductDO extends ShopDOBase {
  String id;
  String shopId;
  String titleShort;
  String titleLong;
  float price;
  float sales;
  String service;
  int totalStock;
  String productDetail;
  String productCategoryId;
  String productCategoryName;

  float displayPrice;
  int soldCount = 0;

  String image;

  public void setDisplayPrice(float displayPrice) {
    this.displayPrice = displayPrice;
  }

  public int getSoldCount() {
    return soldCount;
  }

  public void setSoldCount(int soldCount) {
    this.soldCount = soldCount;
  }

  public float getDisplayPrice() {
    if (sales > -1) {
      return sales;
    }
    return price;
  }

  public String getProductCategoryId() {
    return productCategoryId;
  }

  public void setProductCategoryId(String productCategoryId) {
    this.productCategoryId = productCategoryId;
  }

  public String getProductCategoryName() {
    return productCategoryName;
  }

  public void setProductCategoryName(String productCategoryName) {
    this.productCategoryName = productCategoryName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getShopId() {
    return shopId;
  }

  public void setShopId(String shopId) {
    this.shopId = shopId;
  }

  public String getTitleShort() {
    return titleShort;
  }

  public void setTitleShort(String titleShort) {
    this.titleShort = titleShort;
  }

  public String getTitleLong() {
    return titleLong;
  }

  public void setTitleLong(String titleLong) {
    this.titleLong = titleLong;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public float getSales() {
    return sales;
  }

  public void setSales(float sales) {
    this.sales = sales;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public int getTotalStock() {
    return totalStock;
  }

  public void setTotalStock(int totalStock) {
    this.totalStock = totalStock;
  }

  public String getProductDetail() {
    return productDetail;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public void setProductDetail(String productDetail) {
    this.productDetail = productDetail;
  }

}
