package com.zz.service.impl;

import com.zz.entity.SellerInfo;
import com.zz.repository.SellerInfoRepository;
import com.zz.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bsea
 * 2019-07-29 23:15
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
