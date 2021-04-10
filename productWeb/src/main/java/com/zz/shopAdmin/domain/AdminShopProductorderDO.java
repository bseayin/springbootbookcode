package com.zz.shopAdmin.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单
 * 
 * @author jwh
 * @email jinwenhao
 * @date 2020-12-15 17:09:46
 */
public class AdminShopProductorderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String ordersetid;
	//
	private String userid;
	//
	private String productid;
	//
	private Integer mount;
	//
	private String productepisodeid;
	//订单金额
	private Float price;
	//运费
	private Float transportprice;
	//订单状态 1 created/2 confirmed/3 paid/4 payRecived/5 transport/6 completed
	private Integer status;
	//订单备注
	private String comments;
	//是否active
	private Integer isactive;
	//创建时间
	private Date createdtime;
	//
	private String createdby;
	//更新时间
	private Date updatedtime;
	//
	private String updatedby;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setOrdersetid(String ordersetid) {
		this.ordersetid = ordersetid;
	}
	/**
	 * 获取：
	 */
	public String getOrdersetid() {
		return ordersetid;
	}
	/**
	 * 设置：
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}
	/**
	 * 获取：
	 */
	public String getProductid() {
		return productid;
	}
	/**
	 * 设置：
	 */
	public void setMount(Integer mount) {
		this.mount = mount;
	}
	/**
	 * 获取：
	 */
	public Integer getMount() {
		return mount;
	}
	/**
	 * 设置：
	 */
	public void setProductepisodeid(String productepisodeid) {
		this.productepisodeid = productepisodeid;
	}
	/**
	 * 获取：
	 */
	public String getProductepisodeid() {
		return productepisodeid;
	}
	/**
	 * 设置：订单金额
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * 获取：订单金额
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * 设置：运费
	 */
	public void setTransportprice(Float transportprice) {
		this.transportprice = transportprice;
	}
	/**
	 * 获取：运费
	 */
	public Float getTransportprice() {
		return transportprice;
	}
	/**
	 * 设置：订单状态 1 created/2 confirmed/3 paid/4 payRecived/5 transport/6 completed
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态 1 created/2 confirmed/3 paid/4 payRecived/5 transport/6 completed
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：订单备注
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * 获取：订单备注
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * 设置：是否active
	 */
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	/**
	 * 获取：是否active
	 */
	public Integer getIsactive() {
		return isactive;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedtime() {
		return createdtime;
	}
	/**
	 * 设置：
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	/**
	 * 获取：
	 */
	public String getCreatedby() {
		return createdby;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatedtime() {
		return updatedtime;
	}
	/**
	 * 设置：
	 */
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	/**
	 * 获取：
	 */
	public String getUpdatedby() {
		return updatedby;
	}
}
