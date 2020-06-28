package com.xsz.service;

import com.xsz.dto.TemplateDTO;
import com.xsz.entity.Template;
import com.xsz.enums.StatusEnum;
import com.xsz.enums.TypeEnum;
import com.xsz.repository.TemplateRepository;
import com.xsz.util.KeyUtil;
import com.xsz.util.TemplateConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class TemplateService {
	@Resource
	TemplateRepository templateRepository;

	//新建
	public Template add(Template template) {
		template.setId(KeyUtil.getId());
		template.setCreateTime(new Date());
		return templateRepository.save(template);
	}
	
	//修改

	public Template update(Template template) {
		return templateRepository.save(template);
	}
	
	
	//删除

	public void delete(String id) {
		 templateRepository.deleteById(id);
	}
	
	//查询

	public Template selectById(String id) {
		 return templateRepository.findById(id).get();
	}

	/**
	 * page：设置当前第几页
	 * limit：设置一页显示多少行数据
	 * Integer.parseInt(page) 表示把String类型的page变量，转成Integerl类型
	 *
	 */
	public Page<TemplateDTO> getAll(String page,String limit) {
		Sort sort = new Sort(Sort.Direction.DESC, "createTime");
		Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit),sort);
		Page<Template> page1= templateRepository.findAll(pageable);

		return TemplateConvert.convertToDTO(page1);
	}
	/**
	 * page：设置当前第几页
	 * limit：设置一页显示多少行数据
	 * Integer.parseInt(page) 表示把String类型的page变量，转成Integerl类型
	 *
	 */
	public Page<TemplateDTO> getByNameAndType(String page,String limit,String name,String type) {
		Sort sort = new Sort(Sort.Direction.DESC, "createTime");
		Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit),sort);
		Page<Template> page1= templateRepository.findByNameAndType(pageable,name,Integer.parseInt(type));
		return TemplateConvert.convertToDTO(page1);
	}

}
