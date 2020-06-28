package com.xsz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xsz.entity.Blog;
import com.xsz.entity.Comment;


public interface CommentRepository  extends JpaRepository<Comment,String> {
	public List<Comment> findByBlogId(String blogId);
}
