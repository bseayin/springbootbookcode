package com.xsz.vote.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VoteVO implements Serializable {

    private static final long serialVersionUID = 7780820231535870010L;
    //项目名字
    private  String voteName;
    //主题名字
    private  String topicName;
    //选项内容
    private  String option;
    //主题类型
    private  Byte kinds;
    //状态
    private Byte status;
    //创建日期
    private Date createtime;
    private Integer voteId;
    private Integer voteTopicId;
    private Integer optionId;
    //每个选项被投票的数量
    private Integer voteoptioncount;
}
