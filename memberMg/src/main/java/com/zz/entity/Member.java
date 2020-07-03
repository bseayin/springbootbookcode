package com.zz.entity;





import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Description: 会员
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
@Entity(name="tb_member")
@Data
@DynamicUpdate
public class Member {
    /**
     * 主键
     */
    @Id
    @Column(length=50)
    private String id;
    /**
     * 会员名字
     */
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
    private int phone;

}
