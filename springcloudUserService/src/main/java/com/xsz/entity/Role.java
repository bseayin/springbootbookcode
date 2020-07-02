package com.xsz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Bsea
 *  角色
 *
 */
@Table(name="tb_role")
@Entity
@Getter
@Setter
public class Role  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键ID**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**角色标识程序中判断使用,如"admin",这个是唯一的:**/
    private String role;

    /**角色描述,UI界面显示使用**/
    private String description;

    /**是否可用,如果不可用将不会添加给用户**/
    private Boolean available = Boolean.FALSE;


    @ManyToMany(targetEntity = Permission.class)
    @JoinTable(name="TbRolePermission",
            joinColumns={@JoinColumn(name="roleId")},
            inverseJoinColumns={@JoinColumn(name="permissionId")}
    )
    private Set<Permission> permissions;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;// 一个角色对应多个用户


}
