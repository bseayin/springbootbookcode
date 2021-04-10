package com.zz.schoolwall.service;

import com.zz.schoolwall.domain.SchoolWallMediaDO;

import java.util.List;
import java.util.Map;

public interface SchoolWallMediaService {
    int remove(Long mediaId);

    int save(SchoolWallMediaDO record);

    SchoolWallMediaDO get(Long mediaId);
    List<SchoolWallMediaDO> list(Map<String,Object> map);
    int update(SchoolWallMediaDO record);
}