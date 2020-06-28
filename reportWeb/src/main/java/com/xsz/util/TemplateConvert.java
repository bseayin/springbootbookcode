package com.xsz.util;

import com.xsz.dto.TemplateDTO;
import com.xsz.entity.Template;
import com.xsz.enums.StatusEnum;
import com.xsz.enums.TypeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class TemplateConvert {

    public static Page<TemplateDTO> convertToDTO(Page<Template> page1){
        List<Template> list=page1.getContent();

        // Java7 的写法
//		List<TemplateDTO> list2=new ArrayList<>();
//		for(Template template:list){
//			TemplateDTO dto=new TemplateDTO();
//			BeanUtils.copyProperties(template,dto);
//			dto.setStatusMsg(StatusEnum.getStatusEnum(template.getStatus()).getMsg());
//			dto.setTypeMsg(TypeEnum.getTypeEnum(template.getType()).getMsg());
//			list2.add(dto);
//		}
//		Page<TemplateDTO> page2=new PageImpl(list2,pageable,page1.getTotalElements());
//		return page2;
        // Java8 新特性 写法
        List<TemplateDTO> list2=list.stream().map(e->{
            TemplateDTO dto=new TemplateDTO();
            BeanUtils.copyProperties(e,dto);
            dto.setStatusMsg(StatusEnum.getStatusEnum(e.getStatus()).getMsg());
            dto.setTypeMsg(TypeEnum.getTypeEnum(e.getType()).getMsg());
            return dto;
        }).collect(Collectors.toList());
        Page<TemplateDTO> page2=new PageImpl(list2,page1.getPageable(),page1.getTotalElements());
        return page2;

    }
}
