package com.xsz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xsz.entity.Blog;
import com.xsz.entity.Tag;


public interface TagRepository  extends JpaRepository<Tag,String> {

}
