package com.xsz.job.dao;

import com.xsz.common.config.MyMapper;
import com.xsz.job.domain.Job;

import java.util.List;



public interface JobMapper extends MyMapper<Job> {
	
	List<Job> queryList();
}