package com.xsz.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 
 * @author Bsea
 *
 */
@Entity
@Table(name="tb_comment")
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**主键ID**/
	@Id
	@Column(length=30)
	private String id;
	/**评论作者**/
	@Column(length=30)
	private String author;
	/**内容 **/
	@Column(length=600)
	private String contents;
	/**创建时间**/
	private Date createTime;
	/**博客Id**/
	@Column(length=30)
	private String blogId;
	
	/**上级评论Id**/
	@Column(length=30)
	private String parentCommentId;
	
	/**状态 0表示发表，1表示冻结**/
	private Integer status=0;
	
	/**状态 0表示新发表评论，1表示回复评论**/
	private Integer type=0;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	

}
