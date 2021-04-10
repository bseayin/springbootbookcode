package com.zz.schoolwall.service;

import com.zz.schoolwall.domain.SchoolWallCommentDO;

import java.util.List;
import java.util.Map;

public interface SchoolWallCommentService {
    int remove(Long commentId);
    int logicRemove(Long commentId);
    int increaseLikeNum(Long commentId);
    int decreaseLikeNum(Long commentId);
    int increaseCommentNum(Long commentId);
    int decreaseCommentNum(Long commentId);
    int save(SchoolWallCommentDO record);

    SchoolWallCommentDO get(Long commentId);
    List<SchoolWallCommentDO> list(Map<String,Object> map);
    int count(Map<String,Object> map);
    int update(SchoolWallCommentDO record);
}