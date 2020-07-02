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
 * 火车票
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TestDataChild对象", description="火车票")
public class TestDataChild implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @ApiModelProperty(value = "出发地")
    private String startarea;

    @ApiModelProperty(value = "目的地")
    private String endarea;

    @ApiModelProperty(value = "出发时间")
    private LocalDateTime starttime;

    @ApiModelProperty(value = "代理价格")
    private Double price;

    @ApiModelProperty(value = "业务主表ID")
    private String testDataMainId;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "删除标记")
    private String delFlag;


}
