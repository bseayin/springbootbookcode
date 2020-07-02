package com.xsz.service;

import com.xsz.entity.PositionType;
import com.xsz.repository.PositionTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionTypeService {
    @Resource
    PositionTypeRepository positionTypeRepository;

    /**查询所有职业类别**/
    public List<PositionType> showAll() {
        return positionTypeRepository.findAll();
    }

}
