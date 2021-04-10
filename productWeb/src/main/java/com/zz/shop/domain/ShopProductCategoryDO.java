package com.zz.shop.domain;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;

public class ShopProductCategoryDO extends ShopDOBase {
  String id;
  String pid;
  String name;
  String picture;
  String icon;
  Boolean isOnMainPage;
  Integer sort;

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public Boolean isOnMainPage() {
    return isOnMainPage;
  }

  public void setOnMainPage(boolean onMainPage) {
    isOnMainPage = onMainPage;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }
}
