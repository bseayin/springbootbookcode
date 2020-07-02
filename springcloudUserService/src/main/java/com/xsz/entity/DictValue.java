package com.xsz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name="tbDictValue")
@Entity
@Getter
@Setter
public class DictValue {

    /**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    private String label;		// 标签名
    private String value;		// 键值
    private String sort;		// 排序

    /**创建者**/
    private String create_by;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="dictTypeId", referencedColumnName = "id")
    private DictType dictType;

    public DictValue(){

    }

}
