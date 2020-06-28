package com.xsz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xsz.entity.Blog;


public interface BlogRepository  extends JpaRepository<Blog,String> {
	// 抽象方法，不需要方法体 JPASQL
	//根据标题查找博客文章
	//findBy是固定的不能变，后面接的是java 类Blog的属性名字title. 单词之间第一字母大写
	public Blog findByTitleAndStatus(String title,Integer status);
	//根据作者Id查找博客文章
	public List<Blog> findByAuthorAndStatus(String author,Integer status);

}
