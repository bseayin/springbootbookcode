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
@TableName("tb_d_vote_result")
@ApiModel(value="TbDVoteResult对象", description="")
public class TbDVoteResult implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "投票ID")
    @TableField("VOTEID")
    private Integer voteid;

    @ApiModelProperty(value = "话题ID")
    @TableField("TOPICID")
    private Integer topicid;

    @ApiModelProperty(value = "项ID")
    @TableField("OPTIONID")
    private Integer optionid;

    @ApiModelProperty(value = "用户自定义项ID")
    @TableField("OPTIONEXTID")
    private Integer optionextid;

    @ApiModelProperty(value = "是否匿名投票,0:否,1:是")
    @TableField("ALLOWANONYMITY")
    private Integer allowanonymity;

    @ApiModelProperty(value = "投票人ID")
    @TableField("VOTEUSERID")
    private Integer voteuserid;

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


}
