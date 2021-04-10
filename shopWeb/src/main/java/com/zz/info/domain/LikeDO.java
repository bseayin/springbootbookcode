package com.zz.info.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 信息发布内容/信息评论 点赞
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-12-06 18:20:48
 */
public class LikeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//点赞人
	private String userId;
	//点赞时间
	private Date gtmCreate;
	//content 文章点赞 comment评论点赞
	private String infoType;
	//info_content.cid /info_comment.cid
	private Long infoId;

	/**
	 * 设置：点赞人
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：点赞人
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：点赞时间
	 */
	public void setGtmCreate(Date gtmCreate) {
		this.gtmCreate = gtmCreate;
	}
	/**
	 * 获取：点赞时间
	 */
	public Date getGtmCreate() {
		return gtmCreate;
	}
	/**
	 * 设置：content 文章点赞 comment评论点赞
	 */
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	/**
	 * 获取：content 文章点赞 comment评论点赞
	 */
	public String getInfoType() {
		return infoType;
	}
	/**
	 * 设置：info_content.cid /info_comment.cid
	 */
	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：info_content.cid /info_comment.cid
	 */
	public Long getInfoId() {
		return infoId;
	}
}
