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

import com.xsz.entity.Tag;
import com.xsz.service.TagService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Bsea
 * 	标签管理模块 标签控制类
 */
@RequestMapping("tag")
@RestController
@Api(value = "标签API")
public class TagController {
	@Resource
	TagService tagService;
	//发表标签
	@ApiOperation(value = "新建标签", notes = "新建标签")
	@PostMapping("save")
	public Tag add(@RequestBody Tag tag) {
		return tagService.add(tag);
	}
	//修改标签
	@ApiOperation(value = "修改标签", notes = "修改标签")
	@PostMapping("modify")
	public Tag update(@RequestBody Tag tag) {
		return tagService.update(tag);
	}
	//删除标签
	@ApiOperation(value = "删除标签", notes = "删除标签")
	@ApiImplicitParam(name = "id", value = "标签的主键Id", required = true, dataType = "String", paramType = "path")
	@PostMapping("delete/{id}")
	public Map<String, String> delete(@PathVariable("id") String id) {
		Map<String, String> result=new HashMap();
		tagService.delete(id);
		result.put("result", "success");
		return result;
	}
	
	

    //查询标签
	@ApiOperation(value = "查询所有标签", notes = "查询所有标签")
	@GetMapping("showAll")
	public List<Tag> selectAll() {
		return tagService.selectAll();
	}
	

}
