package com.xsz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Bsea
 *     粉丝表
 */
@Entity
@Table(name="tb_follower")
public class Follower implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=30)
	private String id;
	
	@Column(length=30)
	/**明星用户Id(被关注用户)**/
	private String startId;
	
	@Column(length=30)
	/**粉丝用户Id(关注用户)**/
	private String fololowerId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStartId() {
		return startId;
	}

	public void setStartId(String startId) {
		this.startId = startId;
	}

	public String getFololowerId() {
		return fololowerId;
	}

	public void setFololowerId(String fololowerId) {
		this.fololowerId = fololowerId;
	}

}
