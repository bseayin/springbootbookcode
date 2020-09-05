package com.xsz.system.service;

import java.util.List;

import com.xsz.system.domain.UserOnline;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
