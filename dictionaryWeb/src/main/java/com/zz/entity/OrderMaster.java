package com.zz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * @Description:  订单主表，一个订单对应有且只有一条订单主表记录
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
@Entity
public class OrderMaster {
	/**
	 * 主键
	 */
	@Id
	@Column(length=50)
	private String id;
	/**
	 * 下订单的用户名字
	 */
	private String name;
	/**
	 * 订单的总价
	 */
	private double total;
	/**
	 * 外卖地址
	 */
	private String address;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 一条主表记录对应多个详情
	 * 比如：一条订单包含 米饭，肉，汤 三条详情
	 */
	@OneToMany(mappedBy = "orderMaster")
	private Set<OrderDetail> orderDetailSet =new HashSet<OrderDetail>();

	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}

	public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
