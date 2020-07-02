package com.zz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
/**
 * @Description: 答案
 * @Author: Bsea
 * @CreateDate: 2019/12/27$ 21:03$
 */
@Entity
@Table(name = "tb_answer")
@Data
public class Answer {
    /**
     * 主键
     */
    @Column(length = 50)
    @Id
    private  String id;
    /**
     * 题目id
     */
    private  String qid;
    /**
     * 用户id
     */
    private  String uid;
    /**
     *  结果
     */
    private  boolean result;
    /**
     *  评分
     */
    private  int val;
    /**
     * 内容
     */
    private  String content;
    /**
     * 创建时间
     */
    private Date createTime;
}
