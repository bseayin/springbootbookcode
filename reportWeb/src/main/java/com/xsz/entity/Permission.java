package com.xsz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bsea
 *  权限
 *
 */
@Table(name="tb_permission")
@Entity
@Getter
@Setter
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;//主键.
    private String name;//名称.
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]
    private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子： role:create,role:update,role:delete,role:view

    private Long parentId; //父编号
    private String parentIds; //父编号列表

    private Boolean available = Boolean.FALSE;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="TbRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<Role> roles;
}
