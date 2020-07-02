package com.zz.product.entity;

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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ScoreExchangerules对象", description="")
public class ScoreExchangerules implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private String scoreExchangerulesId;

    @ApiModelProperty(value = "归属公司")
    private String scoreExchangerulesCompanyid;

    @ApiModelProperty(value = "兑换1元 需要的积分")
    @TableField("score_exchangerules_forOneYuan")
    private Float scoreExchangerulesForoneyuan;

    @ApiModelProperty(value = "每次消费最大使用积分")
    private Float scoreExchangerulesShopmaxuse;

    @ApiModelProperty(value = "每日签到 奖励积分")
    private String scoreExchangerulesDailysignin;

    @ApiModelProperty(value = "连续签到天数")
    private Integer scoreExchangerulesContinuesigninDays;

    @ApiModelProperty(value = "连续签到奖励 ")
    private Float scoreExchangerulesContinuesigninReward;

    @ApiModelProperty(value = "是否能 游览所有店积分商品 0-不能 1-能")
    private Integer scoreExchangerulesViewallstock;


}
