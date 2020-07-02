package com.zz.product.serviceImpl;

import com.zz.product.entity.EventLog;
import com.zz.product.mapper.EventLogMapper;
import com.zz.product.service.EventLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Service
public class EventLogServiceImpl extends ServiceImpl<EventLogMapper, EventLog> implements EventLogService {

}
