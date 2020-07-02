package com.zz.product.serviceImpl;

import com.zz.product.entity.TestNote;
import com.zz.product.mapper.TestNoteMapper;
import com.zz.product.service.TestNoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 富文本测试 服务实现类
 * </p>
 *
 * @author Bsea
 * @since 2020-01-25
 */
@Service
public class TestNoteServiceImpl extends ServiceImpl<TestNoteMapper, TestNote> implements TestNoteService {

}
