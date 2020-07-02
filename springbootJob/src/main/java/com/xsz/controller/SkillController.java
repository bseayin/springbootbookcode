package com.xsz.controller;

import com.xsz.service.SkillService;
import com.xsz.util.ResultVOUtil;
import com.xsz.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date:2020/3/28 12:07
 * @Author:bsea
 * 技能
 */
@RestController
@RequestMapping("/skill")
public class SkillController {

    @Resource
    SkillService skillService;

    /**查询所有技能**/
    @GetMapping("showAll")
    public ResultVO showAll(){
        return ResultVOUtil.success(skillService.showAll());
    }
}
