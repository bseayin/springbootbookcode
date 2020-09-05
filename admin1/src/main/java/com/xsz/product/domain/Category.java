package com.xsz.product.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author llf
 * @description: 菜品父类表entity类
 * @date 2020/5/25
 */
@Table(name = "tb_category")
public class Category implements Serializable {
    private static final long serialVersionUID = -4852732617765810959L;
    /**
     * 一级菜单id
     */
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Long categoryId;

    /**
     * 一级菜单名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 一级菜单所属店铺id
     */
    @Column(name = "category_companyid")
    private Long categoryCompanyid;

    /**
     * 一级菜单英文名
     */
    @Column(name = "category_name_en")
    private String categoryNameEn;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更改时间
     */
    private Date updatetime;

    /**
     * 创建人ID
     */
    private Long createman;

    /**
     * 修改人ID
     */
    private Long updateman;


    /**
     * 获取一级菜单id
     *
     * @return category_id - 一级菜单id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置一级菜单id
     *
     * @param categoryId 一级菜单id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取一级菜单名称
     *
     * @return category_name - 一级菜单名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置一级菜单名称
     *
     * @param categoryName 一级菜单名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取一级菜单所属店铺id
     *
     * @return category_companyid - 一级菜单所属店铺id
     */
    public Long getCategoryCompanyid() {
        return categoryCompanyid;
    }

    /**
     * 设置一级菜单所属店铺id
     *
     * @param categoryCompanyid 一级菜单所属店铺id
     */
    public void setCategoryCompanyid(Long categoryCompanyid) {
        this.categoryCompanyid = categoryCompanyid;
    }

    /**
     * 获取一级菜单英文名
     *
     * @return category_name_en - 一级菜单英文名
     */
    public String getCategoryNameEn() {
        return categoryNameEn;
    }

    /**
     * 设置一级菜单英文名
     *
     * @param categoryNameEn 一级菜单英文名
     */
    public void setCategoryNameEn(String categoryNameEn) {
        this.categoryNameEn = categoryNameEn == null ? null : categoryNameEn.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更改时间
     *
     * @return updatetime - 更改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更改时间
     *
     * @param updatetime 更改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人ID
     *
     * @return createman - 创建人ID
     */
    public Long getCreateman() {
        return createman;
    }

    /**
     * 设置创建人ID
     *
     * @param createman 创建人ID
     */
    public void setCreateman(Long createman) {
        this.createman = createman;
    }

    /**
     * 获取修改人ID
     *
     * @return updateman - 修改人ID
     */
    public Long getUpdateman() {
        return updateman;
    }

    /**
     * 设置修改人ID
     *
     * @param updateman 修改人ID
     */
    public void setUpdateman(Long updateman) {
        this.updateman = updateman;
    }


    /**
     * shiro-redis v3.1.0 必须要有getAuthCacheKey()或者getId()方法
     * # Principal id field name. The field which you can get unique id to identify this principal.
     * # For example, if you use UserInfo as Principal class, the id field maybe userId, userName, email, etc.
     * # Remember to add getter to this id field. For example, getUserId(), getUserName(), getEmail(), etc.
     * # Default value is authCacheKey or id, that means your principal object has a method called "getAuthCacheKey()" or "getId()"
     * @return userId as Principal id field name
     */
    public Long getAuthCacheKey() {
        return categoryId;
    }
}