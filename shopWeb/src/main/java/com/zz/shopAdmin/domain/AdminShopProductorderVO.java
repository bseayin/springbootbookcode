package com.zz.shopAdmin.domain;

import com.zz.shop.domain.ShopProductDO;


/**
 * 订单-商品
 * 
 */
public class AdminShopProductorderVO extends ShopProductDO {
	private String productorderId;
	private Float productorderPrice;
	private Integer productorderMount;

	public Integer getProductorderMount() {
		return productorderMount;
	}

	public void setProductorderMount(Integer productorderMount) {
		this.productorderMount = productorderMount;
	}

	public Float getProductorderPrice() {
		return productorderPrice;
	}

	public void setProductorderPrice(Float productorderPrice) {
		this.productorderPrice = productorderPrice;
	}

	public String getProductorderId() {
		return productorderId;
	}

	public void setProductorderId(String productorderId) {
		this.productorderId = productorderId;
	}
}
