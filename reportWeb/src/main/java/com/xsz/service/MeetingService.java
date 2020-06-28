package com.xsz.service;

import com.xsz.entity.Meeting;
import com.xsz.repository.MeetingRepository;
import com.xsz.util.KeyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class MeetingService {
	@Resource
	MeetingRepository meetingRepository;

	//新建
	public Meeting add(Meeting Meeting) {
		Meeting.setId(KeyUtil.getId());
		return meetingRepository.save(Meeting);
	}
	
	//修改

	public Meeting update(Meeting Meeting) {
		return meetingRepository.save(Meeting);
	}

	//添加模板Id

	public int updateTemplate(String templateId,String mId) {
		return meetingRepository.updateTemplateById(templateId,mId);
	}


	//删除

	public void delete(String id) {
		 meetingRepository.deleteById(id);
	}
	
	//查询

	public Meeting selectById(String id) {
		 return meetingRepository.findById(id).get();
	}
	

	public List<Meeting> getAll() {
		return meetingRepository.findAll();
	}



}
