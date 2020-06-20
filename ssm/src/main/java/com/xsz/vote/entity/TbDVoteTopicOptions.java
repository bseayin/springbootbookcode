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
@TableName("tb_d_vote_topic_options")
@ApiModel(value="TbDVoteTopicOptions对象", description="")
public class TbDVoteTopicOptions implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "投票ID")
    @TableField("VOTEID")
    private Integer voteid;

    @ApiModelProperty(value = "投票题目ID")
    @TableField("TOPICID")
    private Integer topicid;

    @ApiModelProperty(value = "选项类型,冗余字段")
    @TableField("KINDS")
    private Integer kinds;

    @ApiModelProperty(value = "选项")
    @TableField("OPTIONS")
    private String options;

    @ApiModelProperty(value = "选项图示")
    @TableField("OPTIONSIMG")
    private String optionsimg;

    @ApiModelProperty(value = "选项的页面HTML代码[保留]")
    @TableField("OPTIONHTML")
    private String optionhtml;

    @ApiModelProperty(value = "排序,正序")
    @TableField("SORTCODE")
    private Integer sortcode;

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

    @ApiModelProperty(value = "备注")
    @TableField("REMARKS")
    private String remarks;


}
