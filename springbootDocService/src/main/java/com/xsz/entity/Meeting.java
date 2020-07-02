package com.xsz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="tb_meeting")
@Getter
@Setter
public class Meeting {
    /**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    @Column(length=30)
    /**会议标题**/
    private String tile;

    /**地点**/
    private String address;

    /**地点**/
    private Date startTime;

    /**报表模板ID**/
    private String templateId;


    // 用户 - 关系定义;

    @ManyToMany
    @JoinTable(name="TbMeetUser",joinColumns={@JoinColumn(name="meetId")},inverseJoinColumns={@JoinColumn(name="uid")})
    private Set<User> userInfos;// 一个会议，可以有多个参加人员
}
