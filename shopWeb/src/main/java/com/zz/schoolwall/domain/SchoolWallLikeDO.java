package com.zz.schoolwall.domain;

import java.io.Serializable;
import java.util.Date;

public class SchoolWallLikeDO implements Serializable {
    private Long likeId;

    private String likeCreateman;

    private Date likeCreatetime;

    private String likeType;

    private Long likeTypeId;

    private String username;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Long getLikeTypeId() {
        return likeTypeId;
    }

    public void setLikeTypeId(Long likeTypeId) {
        this.likeTypeId = likeTypeId;
    }

    public String getLikeCreateman() {
        return likeCreateman;
    }

    public void setLikeCreateman(String likeCreateman) {
        this.likeCreateman = likeCreateman == null ? null : likeCreateman.trim();
    }

    public Date getLikeCreatetime() {
        return likeCreatetime;
    }

    public void setLikeCreatetime(Date likeCreatetime) {
        this.likeCreatetime = likeCreatetime;
    }

    public String getLikeType() {
        return likeType;
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType == null ? null : likeType.trim();
    }
}