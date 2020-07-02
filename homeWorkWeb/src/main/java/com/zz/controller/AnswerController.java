package com.zz.controller;

import com.zz.entity.Answer;
import com.zz.service.AnswerService;
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
@Api(value = "回答控制器")
@RestController
@RequestMapping("answer")
public class AnswerController {
    @Resource
    AnswerService answerService;

    @ApiOperation(value = "获取回答信息", notes = "分页显示回答信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "limit", value = "一页显示记录", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("all/{page}/{limit}")
    public ResultVO findAll(@PathVariable("page") String page,@PathVariable("limit") String limit){
        Pageable pageable= PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));
        return   ResultVOUtil.success(answerService.getAnswerAll(pageable));
    }

    @ApiOperation(value = "获取回答信息", notes = "根据回答id查询回答")
    @ApiImplicitParam(name = "id", value = "回答id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("by/{id}")
    public ResultVO findById(@PathVariable("id") String qid){

        return   ResultVOUtil.success(answerService.getAnswerById(qid));
    }


    @ApiOperation(value = "添加回答", notes = "添加回答")
    @ApiImplicitParam(name = "Answer", value = "回答", required = true, dataType = "Answer")
    @PostMapping("add")
    public ResultVO add(@RequestBody Answer answer){
        answer.setId(KeyUtil.genUniqueKey());
        return   ResultVOUtil.success(answerService.add(answer));
    }


    @ApiOperation(value = "修改回答", notes = "修改回答")
    @ApiImplicitParam(name = "Answer", value = "回答", required = true, dataType = "Answer")
    @PostMapping("update")
    public ResultVO update(@RequestBody Answer answer){

        return   ResultVOUtil.success(answerService.add(answer));
    }

}
