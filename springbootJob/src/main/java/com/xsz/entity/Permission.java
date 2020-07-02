package com.xsz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Date:2020/3/25 12:43
 * @Author:bsea
 * 权限表
 */

@Entity
@Table(name="tb_permission")
@Getter
@Setter
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键ID**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**名称**/
    private String name;

    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]

    private String url;//资源路径.

    private String permission; //权限字符串,menu例子：role:*，button例子： role:create,role:update,role:delete,role:view

    private Long parentId; //父编号

    private String parentIds; //父编号列表

    private Boolean available = Boolean.FALSE;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}
