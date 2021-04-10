package com.zz.shop.domain;

public class ShopCartWithProductInfo {
  String cartId;
  String shopId;
  String titleShort;
  String titleLong;
  float price;
  float sales;
  String service;
  int totalStock;

  String userId;
  String productId;
  int mount  = 0;

  String imageSrc;

  float displayPrice;

  public float getDisplayPrice() {
    if (sales > 0) {
      return sales;
    }
    return price;
  }

  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public int getMount() {
    return mount;
  }

  public void setMount(int mount) {
    this.mount = mount;
  }

  public String getImageSrc() {
    return imageSrc;
  }

  public void setImageSrc(String imageSrc) {
    this.imageSrc = imageSrc;
  }
}
