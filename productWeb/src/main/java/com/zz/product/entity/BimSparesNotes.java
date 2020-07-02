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
 * @since 2020-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BimSparesNotes对象", description="")
public class BimSparesNotes implements Serializable {

    private static final long serialVersionUID=1L;

    private Long sparesNotesId;

    @ApiModelProperty(value = "商品id")
    private Long sparesId;

    @ApiModelProperty(value = "数量")
    private Integer sparesNumber;

    @ApiModelProperty(value = "创建者")
    private String sparesNotesCreateman;

    @ApiModelProperty(value = "创建公司")
    private String sparesNotesCreatecompany;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime sparesNotesCreatetime;

    @ApiModelProperty(value = "记录类型 0-入库 1-出库 2-消费")
    private Integer sparesNotesType;

    private Long sparesNotesShoporder;


}
