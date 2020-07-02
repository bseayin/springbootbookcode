package com.xsz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Date:2020/3/25 13:00
 * @Author:bsea
 * 职位信息表
 */
//@DynamicUpdate
@Entity
@Table(name="tb_position")
@Getter
@Setter
//@EqualsAndHashCode
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    /**名称**/
    @Column(length=30)
    private String name;

    /**创建时间**/
    private Date createDate;

    /**最小薪资**/
    private Integer minSales;

    /**最大薪资**/
    private Integer maxSales;

    /**工作城市**/
    @Column(length=60)
    private String city;

    /**工作详细地址**/
    private String address;

    /**工作详细描述**/
    private String detail;

    /**工作经验要求**/
    private String workedyears;

    /**学历要求**/
    private String education;

    /**招聘人数**/
    private Integer requiredNum;

    /**创建职位企业的Id**/
    @Column(length=60)
    private String createBy;

    /**职位类别Id**/
    private String pid;

    private String skillList;// 一个职位，可以要求有多种技能


    /**求职者简历**/
    @ManyToMany(targetEntity = Resume.class)
    @JoinTable(name = "TbPositionResume",
            joinColumns = {@JoinColumn(name = "pid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "rid", referencedColumnName = "id")}
    )
    private Set<Resume> resumeSet;

}
