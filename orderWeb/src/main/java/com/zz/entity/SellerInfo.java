package com.zz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Bsea
 * 2019-07-23 23:02
 */
@Data
@Entity
public class SellerInfo {

    @Id
    @Column(length=30)
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
