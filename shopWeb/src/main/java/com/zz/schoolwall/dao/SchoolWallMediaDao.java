package com.zz.schoolwall.dao;

import com.zz.schoolwall.domain.SchoolWallMediaDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface SchoolWallMediaDao {
    int deleteByPrimaryKey(Long mediaId);

    int insertSelective(SchoolWallMediaDO record);

    SchoolWallMediaDO selectByPrimaryKey(Long mediaId);
    List<SchoolWallMediaDO> list(Map<String,Object> map);
    int updateByPrimaryKeySelective(SchoolWallMediaDO record);
}