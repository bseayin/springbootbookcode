package com.zz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * @Description:  产品
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
@Entity
@Data
public class Product {
	/**
	 * 主键
	 */
	@Id
	@Column(length=50)
	private String id;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品类型
	 */
	private String productType;
	/**
	 * 产品价格
	 */
	private String productPrice;
}
