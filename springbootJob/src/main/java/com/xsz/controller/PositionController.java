package com.xsz.controller;

import com.xsz.entity.Position;
import com.xsz.entity.User;
import com.xsz.service.PositionService;
import com.xsz.util.ResultVOUtil;
import com.xsz.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date:2020/3/25 17:13
 * @Author:bsea
 * 职位
 */
@RestController
@RequestMapping("/position")
public class PositionController {

    @Resource
    PositionService positionService;
    @Resource
    RestTemplate restTemplate;

    /**根据行业类别查询所有职位名称**/
    @GetMapping("showByTid/{tid}/{page}/{limit}")
    public ResultVO showByTid(@PathVariable("tid") String tid, @PathVariable("page") String page, @PathVariable("limit") String limit){
        return ResultVOUtil.success(positionService.showByTid(tid, page, limit));
    }


    /**查询所有职位信息**/
    @GetMapping("showAll")
    public ResultVO showAll(){
        return ResultVOUtil.success(positionService.showAll());
    }

    /**分页查询所有职位信息**/
    @GetMapping("showAllByPage/{page}/{limit}")
    public ResultVO showAllByPage(@PathVariable("page") String page, @PathVariable("limit") String limit){
        return ResultVOUtil.success(positionService.showAllByPage(page, limit));
    }



    /**添加职位**/
    @PostMapping("addPosition")
    public ResultVO addPosition(@RequestBody Position position, HttpServletRequest request){
        return ResultVOUtil.success(positionService.addPosition(position, (User)request.getSession().getAttribute("loginuser")));
    }

    /**修改职位**/
    @PostMapping("editPosition")
    public ResultVO editPosition(@RequestBody Position position, HttpServletRequest request){
        position.setCreateBy(((User)request.getSession().getAttribute("loginuser")).getId());
        return ResultVOUtil.success(positionService.editPosition(position));
    }

    /**删除职位**/
    @PostMapping("/deletePosition/{id}")
    public ResultVO deletePosition(@PathVariable("id") String id){
        positionService.deletePosition(id);
        Map<String, String> result = new HashMap<>();
        result.put("result", "成功");
        return ResultVOUtil.success(result);
    }

    /**查询求职者**/
    @GetMapping("/showApplicant/{page}/{limit}")
    public ResultVO showApplicant(@PathVariable("page") String page, @PathVariable("limit") String limit, HttpServletRequest request){
        return ResultVOUtil.success(positionService.showApplicant(page, limit, ((User)request.getSession().getAttribute("loginuser")).getId()));
    }

    /**根据createBy查询所有职位**/
    @GetMapping("/showAllByCreateById/{page}/{limit}")
    public ResultVO showAllByCreateById(@PathVariable("page") String page, @PathVariable("limit") String limit, HttpServletRequest request){
        return ResultVOUtil.success(positionService.showAllByCreateById(page, limit, ((User)request.getSession().getAttribute("loginuser")).getId()));
    }

    /**分页显示技能**/
    @ApiOperation("分页显示技能Api")
    @GetMapping("showSkillByLimit/{page}/{limit}")
    public ResultVO showSkillByLimit(@PathVariable("page") String page, @PathVariable("limit") String limit){

        return this.restTemplate.getForObject("http://USERCENTER/dict/showSkillByLimit/{0}/{1}/{2}",ResultVO.class,2, page, limit);
    }

    /**查询所有技能**/
    @ApiOperation("显示所有技能Api")
    @GetMapping("showAllSkill")
    public ResultVO showAllSkill(){

        return this.restTemplate.getForObject("http://USERCENTER/dict/showAllSkill/{0}",ResultVO.class,2);
    }

    /**查询所有的行业**/
    @ApiOperation("显示所有行业Api")
    @GetMapping("showAllIndustry")
    public ResultVO showAllIndustry(HttpServletRequest request){

        return this.restTemplate.getForObject("http://USERCENTER/dict/showAllIndustry/{0}",ResultVO.class,1);
    }

}
