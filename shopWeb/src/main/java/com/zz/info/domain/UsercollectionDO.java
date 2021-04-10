package com.zz.info.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 信息发布内容 的用户收藏
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-12-06 18:20:48
 */
public class UsercollectionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long cid;
	//收藏人
	private String userId;
	//收藏时间
	private Date gtmCreate;
	//状态 1-有效 0-无效
	private Integer status;
	//info_content.cid 
	private Long infoId;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	/**
	 * 设置：收藏人
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：收藏人
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：收藏时间
	 */
	public void setGtmCreate(Date gtmCreate) {
		this.gtmCreate = gtmCreate;
	}
	/**
	 * 获取：收藏时间
	 */
	public Date getGtmCreate() {
		return gtmCreate;
	}
	/**
	 * 设置：状态 1-有效 0-无效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1-有效 0-无效
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：info_content.cid 
	 */
	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：info_content.cid 
	 */
	public Long getInfoId() {
		return infoId;
	}
}
