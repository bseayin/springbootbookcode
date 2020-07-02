package com.xsz.service;

import com.xsz.entity.DictType;
import com.xsz.entity.DictValue;
import com.xsz.repository.DTODao;
import com.xsz.repository.DictTypeRepository;
import com.xsz.repository.DictValueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DictTypeService {

    @Resource
    DictTypeRepository dictTypeRepository;
    @Resource
    DictValueRepository dictValueRepository;
    @Resource
    DTODao dtodao;

    public DictType showAllIndustry(String id){
        return dictTypeRepository.findById(id).get();
    }

    public Page<DictValue> showSkillByLimit(String id, String number, String limit) {
        Pageable pageable = PageRequest.of(Integer.parseInt(number), Integer.parseInt(limit));
        return dictValueRepository.findByDictTypeId(id, pageable);
    }

    public List<DictValue> showAllSkill(String id) {
        Sort sort = new Sort(Sort.Direction.ASC, "label");
        return dictValueRepository.findByDictTypeId(id, sort);
    }
}
