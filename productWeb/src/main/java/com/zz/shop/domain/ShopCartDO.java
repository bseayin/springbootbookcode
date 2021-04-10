package com.zz.shop.domain;

public class ShopCartDO extends ShopDOBase {
  String cardId;
  String userId;
  String productId;
  int mount  = 0;
  String productEpisodeId;

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
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
}
