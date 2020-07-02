package com.xsz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Date:2020/3/25 22:40
 * @Author:bsea
 * 技能表
 */
@Table(name="tb_skill")
@Entity
@Getter
@Setter
public class Skill implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    /**名称**/
    @Column(length=60)
    private String name;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "skillSet")
//    private Set<Position> positionSet;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "skillSet")
//    private Set<Resume> resumeSet;

}
