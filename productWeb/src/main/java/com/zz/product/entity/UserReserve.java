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
@ApiModel(value="UserReserve对象", description="")
public class UserReserve implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "预约订单id，主键")
    private String reserveId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "名字")
    private String userName;

    @ApiModelProperty(value = "预约手机号")
    private String userMobile;

    @ApiModelProperty(value = "预约门店id")
    private String shopId;

    @ApiModelProperty(value = "预约门店名字")
    private String shopName;

    @ApiModelProperty(value = "预约内容")
    private String reserveContent;

    @ApiModelProperty(value = "预约到店时间")
    private LocalDateTime reserveTime;

    @ApiModelProperty(value = "预约备注")
    private String reserveRemark;

    @ApiModelProperty(value = "预约订单状态 0为未处理，1为已处理")
    private String reserveStatus;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "预约人数")
    private String reserveSize;


}
