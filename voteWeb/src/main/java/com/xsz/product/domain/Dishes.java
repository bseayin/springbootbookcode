package com.xsz.product.domain;

import com.xsz.product.enums.DishesEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * @author llf
 * @description: 菜品表entity类
 * @date 2020/5/25
 */
@Table(name = "tb_dishes")
public class Dishes implements Serializable {
    private static final long serialVersionUID = -4852732617765810959L;
    /**
     * 主键编号
     */
    @Id
    @Column(name = "spare_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Long spareId;

    /**
     * 菜品编号
     */
    @Column(name = "spare_code")
    private String spareCode;

    /**
     * 菜品名
     */
    @Column(name = "spare_name")
    private String spareName;

    /**
     * 菜品英文名
     */
    @Column(name = "spare_name_en")
    private String spareNameEn;

    /**
     * 菜品类型
     */
    @Column(name = "spare_kind")
    private String spareKind;

    /**
     * 菜品规格/描述
     */
    @Column(name = "spare_model")
    private String spareModel;

    /**
     * 显示单价
     */
    @Column(name = "spare_price")
    private String sparePrice;

    /**
     * 菜品状态 0:已上架;1:已下架;2:已售罄
     */
    @Column(name = "spare_status")
    private DishesEnum spareStatus;

    /**
     * 创建时间
     */
    @Column(name = "spare_createtime")
    private Date spareCreatetime;

    /**
     * 更改时间
     */
    @Column(name = "spare_updatetime")
    private Date spareUpdatetime;

    /**
     * 创建人ID
     */
    @Column(name = "spare_createman")
    private Long spareCreateman;

    /**
     * 修改人ID
     */
    @Column(name = "spare_updateman")
    private Long spareUpdateman;

    /**
     * 菜品图片
     */
    @Column(name = "spare_photo")
    private String sparePhoto;

    /**
     * 图片地址
     */
    @Column(name = "photo_path")
    private String photoPath;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取主键编号
     *
     * @return spare_id - 主键编号
     */
    public Long getSpareId() {
        return spareId;
    }

    /**
     * 设置主键编号
     *
     * @param spareId 主键编号
     */
    public void setSpareId(Long spareId) {
        this.spareId = spareId;
    }

    /**
     * 获取菜品编号
     *
     * @return spare_code - 菜品编号
     */
    public String getSpareCode() {
        return spareCode;
    }

    /**
     * 设置菜品编号
     *
     * @param spareCode 菜品编号
     */
    public void setSpareCode(String spareCode) {
        this.spareCode = spareCode;
    }

    /**
     * 获取菜品名
     *
     * @return spare_name - 菜品名
     */
    public String getSpareName() {
        return spareName;
    }

    /**
     * 设置菜品名
     *
     * @param spareName 菜品名
     */
    public void setSpareName(String spareName) {
        this.spareName = spareName == null ? null : spareName.trim();
    }

    /**
     * 获取菜品英文名
     *
     * @return spare_name_en - 菜品英文名
     */
    public String getSpareNameEn() {
        return spareNameEn;
    }

    /**
     * 设置菜品英文名
     *
     * @param spareNameEn 菜品英文名
     */
    public void setSpareNameEn(String spareNameEn) {
        this.spareNameEn = spareNameEn == null ? null : spareNameEn.trim();
    }

    /**
     * 获取菜品类型
     *
     * @return spare_kind - 菜品类型
     */
    public String getSpareKind() {
        return spareKind;
    }

    /**
     * 设置菜品类型
     *
     * @param spareKind 菜品类型
     */
    public void setSpareKind(String spareKind) {
        this.spareKind = spareKind == null ? null : spareKind.trim();
    }

    /**
     * 获取菜品规格/描述
     *
     * @return spare_model - 菜品规格/描述
     */
    public String getSpareModel() {
        return spareModel;
    }

    /**
     * 设置菜品规格/描述
     *
     * @param spareModel 菜品规格/描述
     */
    public void setSpareModel(String spareModel) {
        this.spareModel = spareModel == null ? null : spareModel.trim();
    }

    /**
     * 获取单价
     *
     * @return spare_price - 单价
     */
    public String getSparePrice() {
        return sparePrice;
    }

    /**
     * 设置单价
     *
     * @param sparePrice 单价
     */
    public void setSparePrice(String sparePrice) {
        this.sparePrice = sparePrice;
    }

    /**
     * 获取菜品状态
     *
     * @return spare_status - 菜品状态
     */
    public DishesEnum getSpareStatus() {
        return spareStatus;
    }

    /**
     * 设置菜品状态
     *
     * @param spareStatus 菜品状态
     */
    public void setSpareStatus(DishesEnum spareStatus) {
        this.spareStatus = spareStatus;
    }

    /**
     * 获取创建时间
     *
     * @return spare_createtime - 创建时间
     */
    public Date getSpareCreatetime() {
        return spareCreatetime;
    }

    /**
     * 设置创建时间
     *
     * @param spareCreatetime 创建时间
     */
    public void setSpareCreatetime(Date spareCreatetime) {
        this.spareCreatetime = spareCreatetime;
    }

    /**
     * 获取更改时间
     *
     * @return spare_updatetime - 更改时间
     */
    public Date getSpareUpdatetime() {
        return spareUpdatetime;
    }

    /**
     * 设置更改时间
     *
     * @param spareUpdatetime 更改时间
     */
    public void setSpareUpdatetime(Date spareUpdatetime) {
        this.spareUpdatetime = spareUpdatetime;
    }

    /**
     * 获取创建人ID
     *
     * @return spare_createman - 创建人ID
     */
    public Long getSpareCreateman() {
        return spareCreateman;
    }

    /**
     * 设置创建人ID
     *
     * @param spareCreateman 创建人ID
     */
    public void setSpareCreateman(Long spareCreateman) {
        this.spareCreateman = spareCreateman;
    }

    /**
     * 获取修改人ID
     *
     * @return spare_updateman - 修改人ID
     */
    public Long getSpareUpdateman() {
        return spareUpdateman;
    }

    /**
     * 设置修改人ID
     *
     * @param spareUpdateman 修改人ID
     */
    public void setSpareUpdateman(Long spareUpdateman) {
        this.spareUpdateman = spareUpdateman;
    }

    /**
     * 获取菜品图片
     *
     * @return spare_photo - 菜品图片
     */
    public String getSparePhoto() {
        return sparePhoto;
    }

    /**
     * 设置菜品图片
     *
     * @param sparePhoto 菜品图片
     */
    public void setSparePhoto(String sparePhoto) {
        this.sparePhoto = sparePhoto == null ? null : sparePhoto.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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
        return spareId;
    }
}