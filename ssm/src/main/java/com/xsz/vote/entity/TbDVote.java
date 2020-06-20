package com.xsz.vote.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
@TableName("tb_d_vote")
@ApiModel(value="TbDVote对象", description="")
public class TbDVote implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "标题")
    @TableField("TITLE")
    private String title;

    @ApiModelProperty(value = "截止日期")
    @TableField("DEADLINETIME")
    private LocalDate deadlinetime;

    @ApiModelProperty(value = "是否ALL，0：否，1：@ALL")
    @TableField("ISALL")
    private Integer isall;

    @ApiModelProperty(value = "首语")
    @TableField("HEADCONTENT")
    private String headcontent;

    @ApiModelProperty(value = "尾语")
    @TableField("FOOTERCONTENT")
    private String footercontent;

    @ApiModelProperty(value = "是否允许成员查看投票结果,0:否,1:是")
    @TableField("ALLOWSHOWRESULT")
    private Integer allowshowresult;

    @ApiModelProperty(value = "是否允许成员匿名投票")
    @TableField("ALLOWANONYMAT")
    private Integer allowanonymat;

    @ApiModelProperty(value = "创建投票的成员系统ID")
    @TableField("FROMUSERID")
    private Integer fromuserid;

    @ApiModelProperty(value = "状态,0:草稿,1:已发布,2:收集中,3:已结束,")
    @TableField("STATUS")
    private Integer status;

    @ApiModelProperty(value = "备注")
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

    @ApiModelProperty(value = "用户ID列表")
    @TableField("TO_USER")
    private String toUser;

    @ApiModelProperty(value = "部门ID列表")
    @TableField("TO_PARTY")
    private String toParty;

    @ApiModelProperty(value = "标签ID列表")
    @TableField("TO_TAG")
    private String toTag;

    @ApiModelProperty(value = "图文消息对应的图片URL")
    @TableField("PIC_URL")
    private String picUrl;

    @ApiModelProperty(value = "投票静态URL")
    @TableField("VOTEURL")
    private String voteurl;

    @ApiModelProperty(value = "用户投票次数统计")
    @TableField("VOTECOUNT")
    private Integer votecount;


}
