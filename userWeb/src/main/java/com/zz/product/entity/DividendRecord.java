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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DividendRecord对象", description="")
public class DividendRecord implements Serializable {

    private static final long serialVersionUID=1L;

    private Long dividendRecordId;

    @ApiModelProperty(value = "分红收益人")
    private String dividendRecordSourceuser;

    @ApiModelProperty(value = "商品id")
    private String dividendRecordItem;

    @ApiModelProperty(value = "数量")
    private String dividendRecordNumber;

    @ApiModelProperty(value = "销售价格")
    private BigDecimal dividendRecordPrice;

    @ApiModelProperty(value = "分红/提成方案比率")
    private Float dividendRecordItemrate;

    @ApiModelProperty(value = "商品毛利")
    private Float dividendRecordRate;

    @ApiModelProperty(value = "最后计算价格")
    private BigDecimal dividendRecordActualprice;

    private String dividendRecordCreateby;

    private LocalDateTime dividendRecordCreatetime;

    private String dividendRecordCreateman;

    @ApiModelProperty(value = "分红状态 0-未支付 1-支付生效")
    private Integer dividendRecordStatus;

    private Long dividendRecordOrderid;

    @ApiModelProperty(value = "0-股东分红 1-员工分红 2-员工施工提成 3-员工销售提成 5-不为0")
    private Integer dividendRecordType;

    @ApiModelProperty(value = "收益人sys_user  id")
    private String dividendRecordSourceuserid;


}
