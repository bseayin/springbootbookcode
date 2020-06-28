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

import com.xsz.entity.Comment;
import com.xsz.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Bsea
 * 	评论管理模块 评论控制类
 */
@RequestMapping("Comment")
@RestController
@Api(value = "评论API")
public class CommentController {
	@Resource
	CommentService commentService;
	//发表评论
	@ApiOperation(value = "新建评论", notes = "新建评论")
	@PostMapping("save")
	public Comment add(@RequestBody Comment comment) {
		return commentService.add(comment);
	}
	//修改评论
	@ApiOperation(value = "修改评论", notes = "修改评论")
	@PostMapping("modify")
	public Comment update(@RequestBody Comment comment) {
		return commentService.update(comment);
	}
	//删除评论
	@ApiOperation(value = "删除评论", notes = "删除评论")
	@ApiImplicitParam(name = "id", value = "评论的主键Id", required = true, dataType = "String", paramType = "path")
	@PostMapping("delete/{id}")
	public Map<String, String> delete(@PathVariable("id") String id) {
		Map<String, String> result=new HashMap();
		commentService.delete(id);
		result.put("result", "success");
		return result;
	}
	
	

    //查询评论
	@ApiOperation(value = "查询所有评论", notes = "查询所有评论")
	@GetMapping("showAll")
	public List<Comment> selectAll() {
		return commentService.selectAll();
	}
	
	    //根据blog id查询评论
		@ApiOperation(value = "根据博客查询评论", notes = "根据blog id查询评论")
		@GetMapping("showByBlog/{bid}")
		@ApiImplicitParam(name = "bid", value = "评论的主键Id", required = true, dataType = "String", paramType = "path")
		public List<Comment> selectByBlog(@PathVariable("bid") String blogId) {
			return commentService.selectByBlogId(blogId);
		}
	

}
