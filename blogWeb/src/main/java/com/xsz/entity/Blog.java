package com.xsz.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
/**
 * 
 * @author Bsea
 *
 */
@Entity
@Table(name="tb_blog")
@DynamicUpdate
public class Blog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**主键ID**/
	@Id
	@Column(length=30)
	private String id;
	/**作者**/
	@Column(length=30)
	private String author;
	/**内容 @Lob表示长字段 默认是longtext类型**/
	@Lob
	private String contents;
	
	/**标题**/
	@Column(length=30)
	private String title;
	
	/**点击次数**/
	@Column(length=30)
	private Integer clickTime;
	/**创建时间**/
	private Date createTime;
	/**修改时间**/
	private Date modifyTime;
	/**是否置顶**/
	private boolean isTop;
	/**状态 0表示发表，1表示草稿，2表示冻结**/
	private Integer status;
	
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getClickTime() {
		return clickTime;
	}
	public void setClickTime(Integer clickTime) {
		this.clickTime = clickTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public boolean isTop() {
		return isTop;
	}
	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
