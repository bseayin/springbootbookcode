package com.xsz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Date:2020/3/25 13:08
 * @Author:bsea
 * 公司表
 */
@Entity
@Table(name="tb_corporation")
@Getter
@Setter
public class Corporation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    /**名称**/
    @Column(length=90)
    private String name;

    /**密码**/
    @Column(length=90)
    private String pwd;

    /**类型**/
    @Column(length=20)
    private String type;

    /**所属行业**/
    private String industry;

    /**简介**/
    private String introduction;

    /**地址**/
    private String address;

}
