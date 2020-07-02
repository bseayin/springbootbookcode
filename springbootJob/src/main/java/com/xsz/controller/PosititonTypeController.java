package com.xsz.controller;

import com.xsz.service.PositionTypeService;
import com.xsz.util.ResultVOUtil;
import com.xsz.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date:2020/3/27 13:05
 * @Author:bsea
 * 职位类型
 */
@RestController
@RequestMapping("/positionType")
public class PosititonTypeController {

    @Resource
    PositionTypeService positionTypeService;

    /**查询所有职业类别**/
    @GetMapping("showAll")
    public ResultVO showAll(){
        return ResultVOUtil.success(positionTypeService.showAll());
    }
}
