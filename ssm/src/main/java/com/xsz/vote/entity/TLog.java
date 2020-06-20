package com.xsz.vote.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_log")
@ApiModel(value="TLog对象", description="")
public class TLog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "日志ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "操作用户")
    @TableField("USERNAME")
    private String username;

    @ApiModelProperty(value = "操作内容")
    @TableField("OPERATION")
    private String operation;

    @ApiModelProperty(value = "耗时")
    @TableField("TIME")
    private BigDecimal time;

    @ApiModelProperty(value = "操作方法")
    @TableField("METHOD")
    private String method;

    @ApiModelProperty(value = "方法参数")
    @TableField("PARAMS")
    private String params;

    @ApiModelProperty(value = "操作者IP")
    @TableField("IP")
    private String ip;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "操作地点")
    private String location;


}
