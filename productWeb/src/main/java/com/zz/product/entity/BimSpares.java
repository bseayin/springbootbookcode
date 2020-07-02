package com.zz.product.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="BimSpares对象", description="")
public class BimSpares implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "spare_id", type = IdType.AUTO)
    private Long spareId;

    @ApiModelProperty(value = "商品名")
    private String spareName;

    @ApiModelProperty(value = "商品编号")
    private String spareCode;

    @ApiModelProperty(value = "商品类型")
    private String spareKind;

    @ApiModelProperty(value = "商品规格、商品描述")
    private String spareModel;

    @ApiModelProperty(value = "0-产品 1-套餐")
    private String spareCatalog;

    @ApiModelProperty(value = "暂定")
    private String spareBrand;

    @ApiModelProperty(value = "门店")
    private String spareUserfor;

    @ApiModelProperty(value = "股东分红 毛利率 暂定")
    private BigDecimal sparePriceguide;

    @ApiModelProperty(value = "单价")
    private BigDecimal sparePrice;

    @ApiModelProperty(value = "供应商")
    private String spareFactory;

    @ApiModelProperty(value = "暂定")
    private String spareSupply;

    @ApiModelProperty(value = "库存数量 剩余数量")
    private Integer spareStock;

    @ApiModelProperty(value = "暂定")
    private Integer spareStatus;

    @ApiModelProperty(value = "单位（个，瓶，箱。。。）")
    private String spareStockunit;

    @ApiModelProperty(value = "暂定")
    private String spareStockdscrpt;

    @ApiModelProperty(value = "暂定")
    private Integer spareStockop;

    @ApiModelProperty(value = "采购员")
    private String spareStockman;

    @ApiModelProperty(value = "采购时间")
    private LocalDateTime spareStocktime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime spareCreatetime;

    private LocalDateTime spareUpdatetime;

    private String spareUpdateman;

    @ApiModelProperty(value = "总采购数")
    private Integer sparePurchasing;

    @ApiModelProperty(value = "员工分红毛利率")
    @TableField("spare_profitYG")
    private BigDecimal spareProfityg;

    @ApiModelProperty(value = " 产品进价")
    private BigDecimal spareCost;

    @ApiModelProperty(value = "商品图片")
    private String sparePhoto;

    @ApiModelProperty(value = "逻辑删除 0-有效 1-无效")
    private Integer spareIsdelete;


}
