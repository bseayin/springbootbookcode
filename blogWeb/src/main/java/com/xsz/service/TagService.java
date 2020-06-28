package com.xsz.service;



import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xsz.entity.Tag;
import com.xsz.repository.TagRepository;
import com.xsz.util.KeyUtil;

@Service
@CacheConfig(cacheNames = "TagService")
public class TagService {
	@Resource
	TagRepository TagRepository;
	
	public Tag add(Tag Tag) {
		Tag.setId(KeyUtil.getId());
		Tag.setCreateTime(new Date());
		
		return TagRepository.save(Tag);
	}
	@CacheEvict(cacheNames="TagCache", allEntries=true)
	public Tag update(Tag Tag) {
		
		return TagRepository.save(Tag);
	}

	@CacheEvict(cacheNames="TagCache", allEntries=true)
	public void delete(String id) {
		TagRepository.deleteById(id);
	}

	@Cacheable(cacheNames="TagCache")
	public List<Tag> selectAll() {
		return TagRepository.findAll();
	}
}
