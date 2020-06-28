package com.xsz.service;



import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xsz.dto.ArticleDTO;
import com.xsz.entity.Blog;
import com.xsz.entity.BlogTag;
import com.xsz.repository.BlogRepository;
import com.xsz.repository.BlogTagRepository;
import com.xsz.repository.TagRepository;
import com.xsz.util.KeyUtil;

@Service
@CacheConfig(cacheNames = "blogService")
public class BlogService {
	@Resource
	BlogRepository blogRepository;
	@Resource
	BlogTagRepository  blogtagRepository;
	public Blog add(ArticleDTO adto) {
		Blog blog=new Blog();
		// 需要把dto对象里面所有blog相同属性的值赋值到blog对象
		//blog.setContents(adto.getContents());
		//根据属性名字，把第一对象的值，赋值到第二个对象相同属性上
		System.out.println(adto);
		BeanUtils.copyProperties(adto, blog);
		String blogId=KeyUtil.getId();
		blog.setId(blogId);
		blog.setCreateTime(new Date());
		blog.setModifyTime(new Date());
		adto.getTags().forEach(e->{
			BlogTag bt=new BlogTag();
			bt.setId(KeyUtil.getId());
			bt.setBlogId(blogId);
			bt.setTagId(e.getId());
			blogtagRepository.save(bt);
		});
		return blogRepository.save(blog);
	}
	@CachePut(key = "#p0.id")
	public Blog update(Blog blog) {
		blog.setModifyTime(new Date());
		return blogRepository.save(blog);
	}
	@CacheEvict(key = "#p0")
	public void delete(String id) {
		blogRepository.deleteById(id);
	}
	@Cacheable(key = "#p0")
	public Blog selectById(String id) {
		return blogRepository.findById(id).get();
	}
	//查询博客
	@Cacheable
	public Blog selectByTitle(String title) {
		return blogRepository.findByTitleAndStatus(title,0);
	}
	//查询博客
	@Cacheable
	public List<Blog> selectByAuthor(String author) {
		return blogRepository.findByAuthorAndStatus(author,0);
	}
	
	//查询作者的草稿博客
	@Cacheable
	public List<Blog> selectByAuthor2(String author) {
		return blogRepository.findByAuthorAndStatus(author,1);
	}
}
