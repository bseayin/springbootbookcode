package com.zz.repository;

import com.zz.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bsea
 * 2019-07-23 23:04
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
