package com.zz.product.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="UserCard对象", description="")
public class UserCard implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "会员卡编号")
    private Long cardId;

    @ApiModelProperty(value = "会员卡名字")
    private String cardName;

    @ApiModelProperty(value = "分享者id")
    private String shareBy;

    @ApiModelProperty(value = "会员卡数量（股东拥有的卡的数量，如果分享出去，被领了，就减少）")
    private Integer remainingNum;

    @ApiModelProperty(value = "可分享次数")
    private Integer sharingNum;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "卡余额")
    private BigDecimal account;

    @ApiModelProperty(value = "是否有效 0-有效 1-无效")
    private Integer isDel;


}
