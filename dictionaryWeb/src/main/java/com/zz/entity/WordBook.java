package com.zz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @Description:  个人单词本
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
@Entity
@Table(name="tb_wordbook")
@Data
public class WordBook {
    /**
     * 主键
     */
    @Id
    @Column(length=50)
    private String id;

    /**
     * 单词
     */
    private String word;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 创建时间
     */
    private Date createTime;
}

