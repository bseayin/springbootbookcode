package com.zz.product.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "归属公司")
    private String companyId;

    @ApiModelProperty(value = "归属部门")
    private String officeId;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "工号")
    private String no;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "用户头像")
    private String photo;

    @ApiModelProperty(value = "最后登陆IP")
    private String loginIp;

    @ApiModelProperty(value = "最后登陆时间")
    private LocalDateTime loginDate;

    @ApiModelProperty(value = "是否可登录")
    private String loginFlag;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty(value = "二维码")
    private String qrcode;

    @ApiModelProperty(value = "个性签名")
    private String sign;

    @ApiModelProperty(value = "（pmm）")
    private String department;

    @ApiModelProperty(value = "用户状态 1正常 2停用（pmm）")
    private String status;

    @ApiModelProperty(value = "性别 1男 2女（pmm）")
    private String sex;

    @ApiModelProperty(value = "职位（暂用作 用户地址）")
    @TableField("userPosition")
    private String userPosition;

    @ApiModelProperty(value = "车品牌")
    private String carBrand;

    @ApiModelProperty(value = "车牌号")
    private String carLicense;

    @ApiModelProperty(value = "车类型")
    private String carType;

    @ApiModelProperty(value = "驾驶证换证日期")
    private String carChangeLicenseDate;

    @TableField("carChangeLicenseDateLong")
    private LocalDateTime carChangeLicenseDateLong;

    private String carFilenumber;

    @ApiModelProperty(value = "驾驶证 号")
    private String carNumber;

    @ApiModelProperty(value = "引擎号")
    private String carEnginennumber;

    private LocalDateTime carRegisterDate;

    @ApiModelProperty(value = "车辆颜色")
    private String carColour;

    @ApiModelProperty(value = "驾驶公里")
    private BigDecimal carDrivekilometres;

    private BigDecimal carExceptDrivekilometres;

    private String carPhotoOne;

    private String carPhotoTwo;

    private BigDecimal carFrontwheel;

    private BigDecimal carBackwheel;

    private BigDecimal carSparewheel;

    @ApiModelProperty(value = "保险公司")
    private String carSafecompany;

    private Integer carSavecoverage;

    private Integer carSaveprice;

    private LocalDateTime carSaveenddate;

    @TableField("carSaveenddateLong")
    private String carSaveenddateLong;

    @ApiModelProperty(value = "积分")
    private Integer score;

    private String birthday;

    private String userNickname;

    @ApiModelProperty(value = "用户头像")
    private String userPhoto;

    @ApiModelProperty(value = "微信openId")
    @TableField("user_openId")
    private String userOpenid;

    @ApiModelProperty(value = "微信token")
    private String userToken;

    @ApiModelProperty(value = "用户余额")
    private Integer userCoins;

    @ApiModelProperty(value = "用户积分")
    private Integer userScore;

    @ApiModelProperty(value = "1为新用户")
    @TableField("user_isNew")
    private String userIsnew;

    @ApiModelProperty(value = "0未关注公众号，默认为0")
    @TableField("user_isFocus")
    private String userIsfocus;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime userRegisterTime;

    @ApiModelProperty(value = "获取用户信息时间")
    @TableField("user_getInfo_time")
    private LocalDateTime userGetinfoTime;

    @ApiModelProperty(value = "ip地址")
    private String userIp;

    @ApiModelProperty(value = "省份")
    private String userProvince;

    @ApiModelProperty(value = "市")
    private String userCity;

    @ApiModelProperty(value = "更新操作时间")
    private LocalDateTime userUpdateTime;

    @ApiModelProperty(value = "注册手机号")
    private String userTelephone;

    @ApiModelProperty(value = "注册密码")
    private String userPassword;

    @ApiModelProperty(value = "用户角色 0为会员，1为资金股东，2为店长 3-员工 4人脉股东")
    private String userRole;

    @ApiModelProperty(value = "用户性别 0为女 1为男")
    private String userSex;

    @ApiModelProperty(value = "会员是否认证，0未认证，1认证，2待认证")
    @TableField("user_isVerificated")
    private String userIsverificated;

    @ApiModelProperty(value = "用户绑定的股东id")
    private String userOfShareholder;

    @ApiModelProperty(value = "该用户被分配的分红员工")
    private String dividendWorkerid;

    @ApiModelProperty(value = "会员总消费")
    private BigDecimal userTotalConsumption;


}
