package com.xsz.repository;

import com.xsz.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SkillRepository extends JpaRepository<Skill,String>, JpaSpecificationExecutor<Skill> {

}
