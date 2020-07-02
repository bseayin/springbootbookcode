package com.zz.controller;

import com.zz.entity.Question;
import com.zz.service.QuestionService;
import com.zz.util.KeyUtil;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: 2019/12/27
 */
@Api(value = "题目控制器")
@RestController
@RequestMapping("question")
public class QuestionController {
    @Resource
    QuestionService questionService;

    @ApiOperation(value = "获取题目信息", notes = "分页显示题目信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "limit", value = "一页显示记录", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("all/{page}/{limit}")
    public ResultVO findAll(@PathVariable("page") String page,@PathVariable("limit") String limit){
        Pageable pageable= PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));
        return   ResultVOUtil.success(questionService.getQuestionAll(pageable));
    }

    @ApiOperation(value = "获取题目信息", notes = "根据题目id查询题目")
    @ApiImplicitParam(name = "id", value = "题目id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("by/{id}")
    public ResultVO findById(@PathVariable("id") String qid){

        return   ResultVOUtil.success(questionService.getQuestionById(qid));
    }


    @ApiOperation(value = "添加题目", notes = "添加题目")
    @ApiImplicitParam(name = "question", value = "题目", required = true, dataType = "question")
    @PostMapping("add")
    public ResultVO add(@RequestBody Question question){
        question.setId(KeyUtil.genUniqueKey());
        return   ResultVOUtil.success(questionService.add(question));
    }


    @ApiOperation(value = "修改题目", notes = "修改题目")
    @ApiImplicitParam(name = "question", value = "题目", required = true, dataType = "question")
    @PostMapping("update")
    public ResultVO update(@RequestBody Question question){

        return   ResultVOUtil.success(questionService.add(question));
    }

}
