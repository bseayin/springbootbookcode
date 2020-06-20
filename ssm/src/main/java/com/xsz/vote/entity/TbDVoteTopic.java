package com.xsz.vote.entity;

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
@TableName("tb_d_vote_topic")
@ApiModel(value="TbDVoteTopic对象", description="")
public class TbDVoteTopic implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "投票ID")
    @TableField("VOTEID")
    private Integer voteid;

    @ApiModelProperty(value = "类型,来源于字典表,0:单元,1:多选")
    @TableField("KINDS")
    private Integer kinds;

    @ApiModelProperty(value = "题目")
    @TableField("TITLE")
    private String title;

    @ApiModelProperty(value = "每人最多可投票数,对于单选项,该项值为1")
    @TableField("MAXVOTE")
    private Integer maxvote;

    @ApiModelProperty(value = "每人最少可投票数,对于单选项,该项值为1")
    @TableField("MIXVOTE")
    private Integer mixvote;

    @ApiModelProperty(value = "是否允许用户自定义答案,0:是,1:否")
    @TableField("ALLOWUSERDEFINE")
    private Integer allowuserdefine;

    @ApiModelProperty(value = "排序,正序")
    @TableField("SORTCODE")
    private Integer sortcode;

    @TableField("REMARKS")
    private String remarks;

    @ApiModelProperty(value = "删除标记，0：存在，1：删除")
    @TableField("DELMARK")
    private Integer delmark;

    @TableField("CREATETIME")
    private LocalDateTime createtime;

    @TableField("MODIFYTIME")
    private LocalDateTime modifytime;

    @TableField("CREATEUSERID")
    private Integer createuserid;

    @TableField("MODIFYUSERID")
    private Integer modifyuserid;

    @ApiModelProperty(value = "选项个数")
    @TableField("OPTIONCOUNT")
    private Integer optioncount;


}
