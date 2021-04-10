package com.zz.info.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zz.info.domain.Comment;

@Mapper
public interface CommentDao {
	public int save(Comment comment);
	public List<Comment> list(Map<String,Object> map);
	public int count(Map<String,Object> map);
}
