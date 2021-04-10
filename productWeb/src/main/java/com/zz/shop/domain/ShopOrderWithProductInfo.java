package com.zz.shop.domain;

public class ShopOrderWithProductInfo extends ShopDOBase {
  String orderSetId;
  String shopId;
  String titleShort;
  String titleLong;
  float sales;
  float price;
  float transportPrice;
  int status;
  int totalStock;

  String userId;
  String productId;
  int mount  = 0;

  String image;

  float displayPrice;

  public float getDisplayPrice() {
    if (sales > 0) {
      return sales;
    }
    return price;
  }

  public float getSales() {
    return sales;
  }

  public void setSales(float sales) {
    this.sales = sales;
  }

  public String getOrderSetId() {
    return orderSetId;
  }

  public void setOrderSetId(String orderSetId) {
    this.orderSetId = orderSetId;
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

  public float getTransportPrice() {
    return transportPrice;
  }

  public void setTransportPrice(float transportPrice) {
    this.transportPrice = transportPrice;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
