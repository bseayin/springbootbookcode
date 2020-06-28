package com.xsz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xsz.entity.Blog;
import com.xsz.entity.BlogTag;


public interface BlogTagRepository  extends JpaRepository<BlogTag,String> {
	

}
