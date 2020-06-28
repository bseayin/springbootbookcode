package com.xsz.controller;

import com.xsz.entity.Meeting;
import com.xsz.entity.Template;
import com.xsz.service.MeetingService;
import com.xsz.service.TemplateService;
import com.xsz.util.ResultVOUtil;
import com.xsz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 模板控制类
 */
@RestController
@RequestMapping("template")
@Api(value = "模板接口")
public class TemplateController {
    @Resource
    TemplateService templateService;

    @ApiOperation(value = "返回所有模板")
    @GetMapping("listAll/{page}/{limit}")
    public ResultVO list(@PathVariable("page") String page,@PathVariable("limit") String limit ){
        return  ResultVOUtil.success(templateService.getAll(page,limit));
    }


    @ApiOperation(value = "根据名字和类型查找")
    @GetMapping("listBy1/{page}/{limit}/{name}/{type}")
    public ResultVO listBy1(@PathVariable("page") String page,@PathVariable("limit") String limit,@PathVariable("name") String name,@PathVariable("type") String type ){
        return  ResultVOUtil.success(templateService.getByNameAndType(page,limit,name,type));
    }


    @ApiOperation(value = "删除模板")
    @PostMapping("delete/{id}")
    public ResultVO delete(@PathVariable("id") String id){
        templateService.delete(id);
        return  ResultVOUtil.success();
    }

    @ApiOperation(value = "修改模板")
    @PostMapping("update")
    public ResultVO delete(@RequestBody Template template){

        return  ResultVOUtil.success(templateService.update(template));
    }


}
