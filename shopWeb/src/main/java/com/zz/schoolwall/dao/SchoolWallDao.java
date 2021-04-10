package com.zz.schoolwall.dao;

import com.zz.schoolwall.domain.SchoolWallDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchoolWallDao {
    int deleteByPrimaryKey(Long wallId);
    int logicRemove(Long wallId);
    int increaseLikeNum(Long wallId);
    int decreaseLikeNum(Long wallId);
    int increaseCommentNum(Long wallId);
    int decreaseCommentNum(Long wallId);
    int batchLogicRemove(Long[] wallIds);

    int insertSelective(SchoolWallDO record);

    SchoolWallDO selectByPrimaryKey(Long wallId);

    List<SchoolWallDO> list(Map<String,Object> map);
    int count(Map<String,Object> map);

    int updateByPrimaryKeySelective(SchoolWallDO record);
}