package com.zz.service;

import com.zz.entity.SellerInfo;

/**
 * 卖家端
 * Created by Bsea
 * 2019-07-29 23:14
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
