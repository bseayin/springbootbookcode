package com.zz.service;

import com.zz.entity.OrderMaster;
import com.zz.repository.OrderMasterRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @Description:  订单服务类
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
@Service
public class OrderService {
	@Resource
    OrderMasterRepository masterRepository;
	
	public OrderMaster addmaster(OrderMaster master){
		
		return masterRepository.save(master);
	}


	public OrderMaster getById(String  id){

		return masterRepository.findById(id).get();
	}

}
