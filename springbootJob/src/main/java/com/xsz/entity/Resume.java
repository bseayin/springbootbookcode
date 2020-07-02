package com.xsz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Date:2020/3/25 13:42
 * @Author:bsea
 * 简历表
 */
@Entity
@Table(name="tb_resume")
@Getter
@Setter
//@EqualsAndHashCode
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    /**简历名字**/
    @Column(length=30)
    private String resumeName;

    /**姓名**/
    @Column(length=30)
    private String name;

    /**用户手机号码**/
    @Column(length=30)
    private String mobile;

    /**用户性别**/
    @Column(length = 2)
    private String sex;

    /**用户年龄**/
    private Integer age;

    /**自我评价**/
    private String assessment;

    /**证书**/
    private String certificate;

    /**工作经历**/
    private String workedyears;

    /**项目经历**/
    private String projectExp;

    /**培训经历**/
    private String trainExp;

    /**学历**/
    @Column(length = 20)
    private String education;

    /**创建简历的求职用户Id**/
    private String createBy;

    /**专业**/
    @Column(length = 20)
    private String major;

    /**照片地址**/
    private String image;

    /**word简历地址**/
    private String wordPath;

    @JsonIgnore
//    @ManyToMany(mappedBy = "resumeSet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToMany(targetEntity = Position.class)
    @JoinTable(name = "TbPositionResume",
            joinColumns = {@JoinColumn(name = "rid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "pid", referencedColumnName = "id")}
    )
    private Set<Position> positionSet;

}
