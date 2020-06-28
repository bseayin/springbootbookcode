package com.xsz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsz.dto.ArticleDTO;
import com.xsz.entity.Blog;
import com.xsz.service.BlogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Bsea
 * 	文章管理模块 文章控制类
 */
@RequestMapping("article")
@RestController
@Api(value = "文章API")
public class ArticleController {
	@Resource
	BlogService blogService;
	//发表文章
	@ApiOperation(value = "发表文章", notes = "发表文章")
	@ApiImplicitParam(name = "adto", value = "发表文章对象", required = true, dataType = "ArticleDTO")
	@PostMapping("save")
	public Blog add(@RequestBody ArticleDTO adto) {
		return blogService.add(adto);
	}
	//修改文章
	@ApiOperation(value = "修改文章", notes = "修改文章")
	@PostMapping("modify")
	public Blog update(@RequestBody Blog blog) {
		return blogService.update(blog);
	}
	//删除文章
	@ApiOperation(value = "删除文章", notes = "删除文章")
	@ApiImplicitParam(name = "id", value = "文章的主键Id", required = true, dataType = "String", paramType = "path")
	@PostMapping("delete/{id}")
	public Map<String, String> delete(@PathVariable("id") String id) {
		Map<String, String> result=new HashMap();
		blogService.delete(id);
		result.put("result", "success");
		return result;
	}
	
	

    //根据作者查询文章
	@ApiOperation(value = "根据作者查询文章", notes = "根据作者查询文章")
	@ApiImplicitParam(name = "id", value = "作者的主键Id", required = true, dataType = "String", paramType = "path")
	@GetMapping("showByAuthor/{id}")
	public List<Blog> selectByAuthor(@PathVariable("id") String id) {
		return blogService.selectByAuthor(id);
	}
	
	
	 //根据作者查询草稿文章
		@ApiOperation(value = "根据作者查询草稿文章", notes = "根据作者查询草稿文章")
		@ApiImplicitParam(name = "id", value = "作者的主键Id", required = true, dataType = "String", paramType = "path")
		@GetMapping("showByAuthorDraft/{id}")
		public List<Blog> selectByAuthorDraft(@PathVariable("id") String id) {
			return blogService.selectByAuthor2(id);
		}
	
	//根据标题查询文章
	@ApiOperation(value = "根据标题查询文章", notes = "根据标题查询文章")
	@ApiImplicitParam(name = "title", value = "标题", required = true, dataType = "String", paramType = "path")
	@GetMapping("showByTitle/{title}")
	public Blog selectByTitle(@PathVariable("title") String title) {
		return blogService.selectByTitle(title);
	}
	
	
	//根据文章ID查询文章
	@ApiOperation(value = "根据文章ID查询文章")
	@GetMapping("showById/{id}")
	public Blog selectById(@PathVariable("id") String aid) {
		return blogService.selectById(aid);
	}

}
