package com.xsz.controller;

import com.xsz.service.DictTypeService;
import com.xsz.util.ResultVOUtil;
import com.xsz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("dict")
@Api("字典Api")
@Slf4j
public class DictController {
    @Resource
    DictTypeService dictTypeService;

    @ApiOperation(value = "根据字典ID查询行业")
    @GetMapping("/showAllIndustry/{id}")
    public ResultVO showAllIndustry(@PathVariable("id") String id) {
        log.info(id);
        return ResultVOUtil.success( dictTypeService.showAllIndustry(id));
    }

    @ApiOperation(value = "根据字典ID查询技能")
    @GetMapping("/showSkillByLimit/{id}/{number}/{limit}")
    public ResultVO showSkillByLimit(@PathVariable("id") String id, @PathVariable("number") String number, @PathVariable("limit") String limit) {
        log.info(id);
        return ResultVOUtil.success( dictTypeService.showSkillByLimit(id, number, limit));
    }


    @ApiOperation(value = "根据字典ID查询技能")
    @GetMapping("/showAllSkill/{id}")
    public ResultVO showAllSkill(@PathVariable("id") String id) {
        log.info(id);
        return ResultVOUtil.success( dictTypeService.showAllSkill(id));
    }
}
