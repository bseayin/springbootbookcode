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
@ApiModel(value="Shareholder对象", description="")
public class Shareholder implements Serializable {

    private static final long serialVersionUID=1L;

    private Long shareholderId;

    private String name;

    private String phone;

    @ApiModelProperty(value = "保证金")
    private Float deposit;

    @ApiModelProperty(value = "入股数")
    private Float sharesNumber;

    @ApiModelProperty(value = "返还保证金 0-否 1-是")
    private String depositFlag;

    @ApiModelProperty(value = "股本是否可消费 0 -否 1 -是")
    private String sharesNumberFlag;

    private Long dividendPlanId;

    @ApiModelProperty(value = "介绍人")
    private String introducer;

    @ApiModelProperty(value = "备注非必须")
    private String remarks;

    private LocalDateTime createTime;

    private String userId;

    @ApiModelProperty(value = "所属门店,来源分红方案表")
    private String createCompany;


}
