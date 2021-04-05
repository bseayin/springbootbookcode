package com.zz.form;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: ${Date}
 */

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/10/13$ 21:57$
 */
@Data

public class MemberForm {
    /**
     * 主键
     */
    @Id
    @Column(length=50)
    private String id;
    /**
     * 会员名字
     */
    @NotEmpty(message="姓名必填")
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private int age;
    /**
     *  等级
     */
    private int level;
    /**
     * 状态
     */
    private int status;
    /**
     * 持有汽车数量
     */
    private int carNum;
    /**
     * 创建会员时间
     */
    private String createTime;

    /**
     * 电话
     */
    private String phone;
}
