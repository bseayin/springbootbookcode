package com.zz.info.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Index {
	private String id;
	private String title;
	
	@JsonProperty("photo_url")
	private String photoUrl;
	
	private String read;
	
	@JsonProperty("create_time")
	private String createTime;
	
	private String source;
	
	@JsonProperty("comment_count")
	private String commentCount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
	
	
}
