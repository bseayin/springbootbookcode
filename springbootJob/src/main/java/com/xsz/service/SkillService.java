package com.xsz.service;

import com.xsz.entity.Skill;
import com.xsz.repository.SkillRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkillService {
    @Resource
    SkillRepository skillRepository;

    /**查询所有技能**/
    public List<Skill> showAll() {
        return skillRepository.findAll();
    }

}
