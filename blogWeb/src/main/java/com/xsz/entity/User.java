package com.xsz.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Bsea
 *
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**主键ID**/
	@Id
	@Column(length=30)
	private String id;
	
	@Column(length=30)
	/**用户名**/
	private String name;
	
	@Column(length=30)
	/**用户登录密码**/
	private String pwd;
	
	/**用户角色**/
	private Integer role;
	
	/**头像**/
	private String logo;
	
	@Column(length=30)
	/**用户手机号码**/
	private String mobile;
	
	
	/**用户性别**/
	private String sex;
	
	/**用户积分**/
	private Integer mark;
	
	/**用户等级**/
	private Integer level;
	
	
	/**用户状态0表示激化 1表示冻结**/
	private Integer status=0;

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	

}
