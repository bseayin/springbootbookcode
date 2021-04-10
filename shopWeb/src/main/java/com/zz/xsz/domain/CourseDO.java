package com.zz.xsz.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 课程管理
 * 
 * @author bsea
 * @email yinyouhai@aliyun.com
 * @date 2020-10-13 22:53:49
 */
public class CourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long courseId;
	//父课程ID，一级课程为0
	private Long parentId;
	//课程名称
	private String name;
	//课程URL
	private String url;
	//授权(多个用逗号分隔，如：user:list,user:create)
	private String perms;
	//类型   0：目录   1：课程   2：按钮
	private Integer type;
	//课程图标
	private String icon;
	//排序
	private Integer orderNum;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;

	/**
	 * 设置：
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * 设置：父课程ID，一级课程为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父课程ID，一级课程为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：课程名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：课程名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：课程URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：课程URL
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}
	/**
	 * 获取：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public String getPerms() {
		return perms;
	}
	/**
	 * 设置：类型   0：目录   1：课程   2：按钮
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型   0：目录   1：课程   2：按钮
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：课程图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：课程图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
}
