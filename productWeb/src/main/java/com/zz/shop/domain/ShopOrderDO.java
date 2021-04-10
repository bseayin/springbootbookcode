package com.zz.shop.domain;

public class ShopOrderDO extends ShopDOBase {
  String id;
  String orderSetId;
  String userId;
  String productId;
  int mount  = 0;
  String productEpisodeId;
  float price;
  float transportPrice;
  int status;
  String comments;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOrderSetId() {
    return orderSetId;
  }

  public void setOrderSetId(String orderSetId) {
    this.orderSetId = orderSetId;
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

  public String getProductEpisodeId() {
    return productEpisodeId;
  }

  public void setProductEpisodeId(String productEpisodeId) {
    this.productEpisodeId = productEpisodeId;
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

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
}
