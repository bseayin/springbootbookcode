package com.zz.product.entity;

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
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="WxUserInfo对象", description="")
public class WxUserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    @TableField("user_nickName")
    private String userNickname;

    @ApiModelProperty(value = "用户头像")
    private String userPhoto;

    @ApiModelProperty(value = "微信openId")
    @TableField("user_openId")
    private String userOpenid;

    @ApiModelProperty(value = "微信openId")
    private String userToken;

    @ApiModelProperty(value = "性别")
    private String userSex;

    @ApiModelProperty(value = "用户余额")
    private Integer userCoins;

    @ApiModelProperty(value = "用户积分")
    private Integer userScore;

    @ApiModelProperty(value = "1为新用户")
    @TableField("user_isNew")
    private Boolean userIsnew;

    @ApiModelProperty(value = "1未关注公众号")
    @TableField("user_isFocus")
    private Boolean userIsfocus;

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
    private String userPassworld;

    @ApiModelProperty(value = "用户角色 0为会员，1为股东")
    private String userRole;


}
