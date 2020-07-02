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
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DividentDailyStatistics对象", description="")
public class DividentDailyStatistics implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "daily_id", type = IdType.AUTO)
    private Long dailyId;

    @ApiModelProperty(value = "订单id")
    private Long oredrId;

    @ApiModelProperty(value = "分红收益者id")
    private String dividendUserId;

    @ApiModelProperty(value = "订单用户id")
    private String orderUser;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "来源商户id")
    private String companyId;

    @ApiModelProperty(value = "订单分红金额")
    private BigDecimal orderDividend;


}
