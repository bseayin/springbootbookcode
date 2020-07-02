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
 * 校验测试表单
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TestValidation对象", description="校验测试表单")
public class TestValidation implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @ApiModelProperty(value = "浮点数字")
    private Double num;

    @ApiModelProperty(value = "整数")
    private Integer num2;

    @ApiModelProperty(value = "字符串")
    private String str;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "网址")
    private String url;

    @ApiModelProperty(value = "日期")
    private LocalDateTime newDate;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "浮点数小于等于0")
    private String c1;

    @ApiModelProperty(value = "身份证号码")
    private String c2;

    @ApiModelProperty(value = "QQ号码")
    private String c3;

    @ApiModelProperty(value = "手机号码")
    private String c4;

    @ApiModelProperty(value = "中英文数字下划线")
    private String c5;

    @ApiModelProperty(value = "合法字符(a-z A-Z 0-9)")
    private String c6;

    @ApiModelProperty(value = "英语")
    private String en;

    @ApiModelProperty(value = "汉子")
    private String zn;

    @ApiModelProperty(value = "汉英字符")
    private String enzn;


}
