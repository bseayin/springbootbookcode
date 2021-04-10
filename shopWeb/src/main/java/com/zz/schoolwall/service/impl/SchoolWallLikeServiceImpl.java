package com.zz.schoolwall.service.impl;

import com.zz.schoolwall.dao.SchoolWallLikeDao;
import com.zz.schoolwall.domain.SchoolWallLikeDO;
import com.zz.schoolwall.service.SchoolWallLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchoolWallLikeServiceImpl  implements SchoolWallLikeService {
    @Autowired
    private SchoolWallLikeDao schoolWallLikeDao;

    @Override
    public int remove(Long likeId) {
        return schoolWallLikeDao.deleteByPrimaryKey(likeId);
    }

    @Override
    public int save(SchoolWallLikeDO record) {
        return schoolWallLikeDao.insertSelective(record);
    }

    @Override
    public SchoolWallLikeDO get(Long likeId) {
        return schoolWallLikeDao.selectByPrimaryKey(likeId);
    }
    @Override
    public List<SchoolWallLikeDO> list(Map<String,Object> map) {
        return schoolWallLikeDao.list(map);
    }
    @Override
    public int count(Map<String,Object> map) {
        return schoolWallLikeDao.count(map);
    }

    @Override
    public int update(SchoolWallLikeDO record) {
        return schoolWallLikeDao.updateByPrimaryKeySelective(record);
    }
}