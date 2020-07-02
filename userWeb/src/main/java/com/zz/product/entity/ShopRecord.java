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
@ApiModel(value="ShopRecord对象", description="")
public class ShopRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Long shopRecordId;

    @ApiModelProperty(value = "商品id")
    private Long shopRecordSparesId;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal shopRecordPrice;

    @ApiModelProperty(value = "商品数量")
    private Integer shopRecordNumber;

    @ApiModelProperty(value = "商品单位")
    private String shopRecordUnit;

    @ApiModelProperty(value = "折扣")
    private Float shopRecordDiscount;

    @ApiModelProperty(value = "实际支付金额")
    private BigDecimal shopRecordActualprice;

    @ApiModelProperty(value = "施工人员  分红类型2")
    private String shopRecordOperater;

    @ApiModelProperty(value = "销售人员 分红类型3")
    private String shopRecordSalesman;

    @ApiModelProperty(value = "订单号")
    private Long shopOrderId;

    @ApiModelProperty(value = "使用套餐时 的 套餐id")
    private Long mealId;

    @ApiModelProperty(value = "shop_record状态 0-草稿 1-正式提交")
    private String shopRecordStatus;

    private LocalDateTime shopRecordUpdatetime;

    private String productName;

    private String productUrl;


}
