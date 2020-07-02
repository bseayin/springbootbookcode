package com.xsz.repository;

import com.xsz.entity.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<User,String>  第一个参数是实体类，第二个参数是实体类的主键数据类型
public interface TemplateRepository extends JpaRepository<Template,String> {
	
    public Page<Template> findByNameAndType(Pageable pageable, String name, Integer type);

}
