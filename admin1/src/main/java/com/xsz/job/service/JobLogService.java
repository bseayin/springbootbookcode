package com.xsz.job.service;

import java.util.List;

import com.xsz.common.service.IService;
import com.xsz.job.domain.JobLog;

public interface JobLogService extends IService<JobLog> {

	List<JobLog> findAllJobLogs(JobLog jobLog);

	void saveJobLog(JobLog log);
	
	void deleteBatch(String jobLogIds);
}
