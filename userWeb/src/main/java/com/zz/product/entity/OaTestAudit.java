package com.zz.product.entity;

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
 * 审批流程测试表
 * </p>
 *
 * @author Bsea
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OaTestAudit对象", description="审批流程测试表")
public class OaTestAudit implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "流程实例ID")
    @TableField("PROC_INS_ID")
    private String procInsId;

    @ApiModelProperty(value = "变动用户")
    @TableField("USER_ID")
    private String userId;

    @ApiModelProperty(value = "归属部门")
    @TableField("OFFICE_ID")
    private String officeId;

    @ApiModelProperty(value = "岗位")
    @TableField("POST")
    private String post;

    @ApiModelProperty(value = "性别")
    @TableField("AGE")
    private String age;

    @ApiModelProperty(value = "学历")
    @TableField("EDU")
    private String edu;

    @ApiModelProperty(value = "调整原因")
    @TableField("CONTENT")
    private String content;

    @ApiModelProperty(value = "现行标准 薪酬档级")
    @TableField("OLDA")
    private String olda;

    @ApiModelProperty(value = "现行标准 月工资额")
    @TableField("OLDB")
    private String oldb;

    @ApiModelProperty(value = "现行标准 年薪总额")
    @TableField("OLDC")
    private String oldc;

    @ApiModelProperty(value = "调整后标准 薪酬档级")
    @TableField("NEWA")
    private String newa;

    @ApiModelProperty(value = "调整后标准 月工资额")
    @TableField("NEWB")
    private String newb;

    @ApiModelProperty(value = "调整后标准 年薪总额")
    @TableField("NEWC")
    private String newc;

    @ApiModelProperty(value = "月增资")
    @TableField("ADD_NUM")
    private String addNum;

    @ApiModelProperty(value = "执行时间")
    @TableField("EXE_DATE")
    private String exeDate;

    @ApiModelProperty(value = "人力资源部门意见")
    @TableField("HR_TEXT")
    private String hrText;

    @ApiModelProperty(value = "分管领导意见")
    @TableField("LEAD_TEXT")
    private String leadText;

    @ApiModelProperty(value = "集团主要领导意见")
    @TableField("MAIN_LEAD_TEXT")
    private String mainLeadText;

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
