package com.xsz.service;



import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xsz.entity.Comment;
import com.xsz.repository.CommentRepository;
import com.xsz.util.KeyUtil;

@Service
@CacheConfig(cacheNames = "CommentService")
public class CommentService {
	@Resource
	CommentRepository commentRepository;
	
	public Comment add(Comment comment) {
		comment.setId(KeyUtil.getId());
		comment.setCreateTime(new Date());
		
		return commentRepository.save(comment);
	}
	@CachePut(key = "#p0.id")
	public Comment update(Comment comment) {
		
		return commentRepository.save(comment);
	}
	@CacheEvict(key = "#p0")
	public void delete(String id) {
		commentRepository.deleteById(id);
	}
	@Cacheable
	public List<Comment> selectAll() {
		return commentRepository.findAll();
	}
	@Cacheable(key = "#p0")
	public List<Comment> selectByBlogId(String blogId) {
		return commentRepository.findByBlogId(blogId);
	}
}
