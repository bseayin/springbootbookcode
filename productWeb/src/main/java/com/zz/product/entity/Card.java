package com.zz.product.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@ApiModel(value="Card对象", description="")
public class Card implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Integer id;

    @ApiModelProperty(value = "门店编号")
    private String groupid;

    @ApiModelProperty(value = "卡id（主键）")
    private Long cardid;

    private String cardname;

    @ApiModelProperty(value = "余额")
    private BigDecimal amt;

    @ApiModelProperty(value = "有效期")
    private Integer avaiabletime;

    @ApiModelProperty(value = "是否可以分享（0-否 1-是）")
    private String isshared;

    @ApiModelProperty(value = "来源（0-门店 1-总店）")
    private String source;

    @ApiModelProperty(value = "绑定套餐")
    private String cardset;

    @ApiModelProperty(value = "状态（0-使用 1-停用）")
    private String status;

    @ApiModelProperty(value = "备注")
    private String comment;

    private String modifyby;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "每1积分 需要的消费金额")
    private Float exchangerules;

    @ApiModelProperty(value = "卡类型名字")
    private String cardTypeName;

    @ApiModelProperty(value = "卡类型等级")
    private Integer cardTypeLevel;

    @ApiModelProperty(value = "卡编号（用户手机号）")
    private String cardcode;

    private LocalDateTime updatetime;

    @ApiModelProperty(value = "卡类型id")
    private Long cardTypeId;

    @ApiModelProperty(value = "分享者id")
    private String shareBy;

    @ApiModelProperty(value = "会员卡数量（股东拥有的卡的数量，如果分享出去，被领了，就减少）")
    private Integer remainingNum;

    @ApiModelProperty(value = "可分享次数")
    private Integer sharingNum;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "会员卡所属股东id")
    private String userOfShareholder;


}
