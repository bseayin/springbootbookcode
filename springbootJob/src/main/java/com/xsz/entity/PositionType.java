package com.xsz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Date:2020/3/25 22:35
 * @Author:bsea
 * 职位类别表
 */
@Entity
@Table(name="tb_positionType")
@Getter
@Setter
public class PositionType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    /**名称**/
    @Column(length=30)
    private String name;

}
