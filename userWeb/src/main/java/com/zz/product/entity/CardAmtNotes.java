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
@ApiModel(value="CardAmtNotes对象", description="")
public class CardAmtNotes implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "余额操作记录id")
    private Long cardAmtNotesId;

    @ApiModelProperty(value = "操作卡号")
    private Long cardAmtNotesCardid;

    @ApiModelProperty(value = "操作金额")
    private BigDecimal cardAmtNotesAccount;

    @ApiModelProperty(value = "操作时间")
    private LocalDateTime cardAmtNotesCreatetime;

    @ApiModelProperty(value = "操作人")
    private String cardAmtNotesCreateman;

    @ApiModelProperty(value = "操作公司")
    private String cardAmtNotesCreatecompany;

    @ApiModelProperty(value = "操作类型 0-充值 1-取钱 2-消费")
    private String cardAmtNotesType;


}
