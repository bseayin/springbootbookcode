package com.zz.shopAdmin.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;



/**
 * 产品类别
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-28 22:01:10
 */
@Data
public class ProductinproductcategoryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String productId;
	//
	private String productCategoryId;
	//是否active
	private Integer isActive;
	//创建时间
	private Date createdTime;
	//
	private String createdBy;
	//更新时间
	private Date updatedTime;
	//
	private String updatedBy;
	private String name;

	private Integer sort;
}
