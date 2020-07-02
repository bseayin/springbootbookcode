package com.zz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @Description: 评论
 * @Author: Bsea
 * @CreateDate: 2019/12/27$ 21:03$
 */
@Entity
@Table(name = "tb_comments")
@Data
public class Comments {
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
     * 评论人id
     */
    private  String uid;
    /**
     * 答案id
     */
    private  String aid;

    /**
     * 内容
     */
    private  String content;
    /**
     * 创建时间
     */
    private Date createTime;
}
