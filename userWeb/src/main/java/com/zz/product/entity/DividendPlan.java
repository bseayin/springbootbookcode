package com.zz.product.entity;

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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DividendPlan对象", description="")
public class DividendPlan implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;

    private Float dividendNumber;

    @ApiModelProperty(value = "0-使用 1-禁用")
    private Integer status;

    private LocalDateTime updateTime;

    private Long dividendPlanId;

    private String createCompany;

    @ApiModelProperty(value = "（new）0-股东分红方案 1-员工分红方案 2-员工施工提成方案 3-员工销售提成方案 4-人脉股东方案")
    private Boolean dividendPlanType;


}
