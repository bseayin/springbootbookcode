package com.zz.entity;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: 2019/12/27
 */

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @Description: 题目
 * @Author: Bsea
 * @CreateDate: 2019/12/27$ 21:03$
 */
@Entity
@Table(name = "tb_question")
@Data
public class Question {
    /**
     * 主键
     */
    @Column(length = 50)
    @Id
    private  String id;
    /**
     * 标题
     */
    private  String title;
    /**
     * 难度等级
     */
    private  int level;
    /**
     * 内容
     */
    private  String content;
    /**
     * 创建人
     */
    private  String createBy;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 类型
     */
    private  String type;
    /**
     * 上级标题
     */
    private  String parent;
}
