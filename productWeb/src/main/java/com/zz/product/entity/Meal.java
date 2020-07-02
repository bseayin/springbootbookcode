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
 * 
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Meal对象", description="")
public class Meal implements Serializable {

    private static final long serialVersionUID=1L;

    private Long mealId;

    private String mealName;

    private String mealPrice;

    @ApiModelProperty(value = "使用次数")
    private String mealNumber;

    @ApiModelProperty(value = "有效天数")
    private String mealValidity;

    @ApiModelProperty(value = "是否分享到总店 0-否 1-是")
    private Integer mealIsshare;

    @ApiModelProperty(value = "来源 0-分店 1-总店")
    private Integer mealSource;

    @ApiModelProperty(value = "0-正常 1-停用")
    private Integer mealStatus;

    private String mealRemarks;

    private LocalDateTime mealUpdatetime;

    @ApiModelProperty(value = "股东分红 毛利润")
    private BigDecimal mealProfit;

    @ApiModelProperty(value = "创建门店")
    private String mealCreateby;

    @ApiModelProperty(value = "员工分红毛利率")
    @TableField("meal_profitYG")
    private Float mealProfityg;

    @ApiModelProperty(value = "套餐图片")
    private String mealPhoto;

    @ApiModelProperty(value = "截止时间")
    private LocalDateTime mealEndtime;

    @ApiModelProperty(value = "分享次数")
    private Integer mealSharenumber;


}
