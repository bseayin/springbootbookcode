package com.zz.shop.domain;

public class ShopProductEpisodeDO extends ShopDOBase {
  String id;
  String productId;
  String episode;
  String category;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getEpisode() {
    return episode;
  }

  public void setEpisode(String episode) {
    this.episode = episode;
  }
}
