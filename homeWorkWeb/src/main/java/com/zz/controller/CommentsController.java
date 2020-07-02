package com.zz.controller;

import com.zz.entity.Comments;
import com.zz.service.CommentsService;
import com.zz.service.CommentsService;
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
@Api(value = "评论控制器")
@RestController
@RequestMapping("comments")
public class CommentsController {
    @Resource
    CommentsService commentsService;

    @ApiOperation(value = "获取评论信息", notes = "分页显示评论信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "limit", value = "一页显示记录", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("all/{page}/{limit}")
    public ResultVO findAll(@PathVariable("page") String page,@PathVariable("limit") String limit){
        Pageable pageable= PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));
        return   ResultVOUtil.success(commentsService.getCommentsAll(pageable));
    }

    @ApiOperation(value = "获取评论信息", notes = "根据评论id查询评论")
    @ApiImplicitParam(name = "id", value = "评论id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("by/{id}")
    public ResultVO findById(@PathVariable("id") String qid){

        return   ResultVOUtil.success(commentsService.getCommentsById(qid));
    }


    @ApiOperation(value = "添加评论", notes = "添加评论")
    @ApiImplicitParam(name = "comments", value = "评论", required = true, dataType = "comments")
    @PostMapping("add")
    public ResultVO add(@RequestBody Comments comments){
        comments.setId(KeyUtil.genUniqueKey());
        return   ResultVOUtil.success(commentsService.add(comments));
    }


    @ApiOperation(value = "修改评论", notes = "修改评论")
    @ApiImplicitParam(name = "comments", value = "评论", required = true, dataType = "comments")
    @PostMapping("update")
    public ResultVO update(@RequestBody Comments comments){

        return   ResultVOUtil.success(commentsService.add(comments));
    }

}
