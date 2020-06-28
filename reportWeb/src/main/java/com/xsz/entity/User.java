package com.xsz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @author Bsea
 *  用户表
 *
 */
@Entity
@Table(name="tb_user")
@Getter
@Setter
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**主键ID**/
	@Id
	@Column(length=60)
	private String id;
	
	@Column(length=30)
	/**用户名**/
	private String name;
	
	@Column(length=90)
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

	private String salt;//加密密码的盐

	@ManyToMany(fetch=FetchType.EAGER)//立即从数据库中进行加载数据;
	@JoinTable(name = "TbUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns
			={@JoinColumn(name = "roleId") })
	private Set<Role> roleList;// 一个用户具有多个角色


	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)//立即从数据库中进行加载数据;
	@JoinTable(name = "TbMeetUser", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns
			={@JoinColumn(name = "meetId") })
	private Set<Meeting> meetList;


	/**
	 * 密码盐. * @return
	 * 这个方法重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解了。
	 */
	public String getCredentialsSalt(){
		return this.name+this.salt;

	}



}
