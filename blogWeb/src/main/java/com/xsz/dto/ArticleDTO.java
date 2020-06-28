package com.xsz.dto;

import java.util.List;

import com.xsz.entity.Blog;
import com.xsz.entity.Tag;

public class ArticleDTO extends Blog {
	private List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
}
