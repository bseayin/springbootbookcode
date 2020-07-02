package com.xsz.entity;

import com.xsz.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 报告模板
 */
@Entity
@Table(name="tb_template")
@Getter
@Setter
public class Template {
    /**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    /**模板名字**/
    @Column(length=60)
    private String name;

    /**路径**/
    @Column
    private String path;

    /**创建日期**/
    @Column
    private Date createTime;

    /**创建人**/
    @Column(length=60)
    private String crdeateBy;

    /**状态 默认是0表示可以使用，1表示冻结状态**/
    @Column
    private Integer status= StatusEnum.UNLOCK.getValue();

    /**模板类型  1,表示word, 2表示pdf**/
    @Column
    private Integer type;
}
