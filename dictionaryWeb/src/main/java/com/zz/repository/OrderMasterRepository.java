package com.zz.repository;
/**
 * @Description:  订单
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
import com.zz.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {



}
