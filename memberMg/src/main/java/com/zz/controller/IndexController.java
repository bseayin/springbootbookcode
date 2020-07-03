package com.zz.controller;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: ${Date}
 */

import com.zz.config.DataValidationException;
import com.zz.entity.Member;
import com.zz.form.MemberForm;
import com.zz.service.MemberService;
import com.zz.util.FormUtil;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/10/16$ 21:27$
 */
@Api(value = "会员控制器")
@Controller
@RequestMapping("index")
public class IndexController {
    @Resource
    MemberService memberService;

    @ApiOperation(value = "添加会员", notes = "根据名字查找会员")
    @ApiImplicitParam(name = "name", value = "会员名字", required = true, dataType = "String",paramType = "path")
    @PostMapping("add")
    public String  add(@Valid MemberForm member, BindingResult bindingResult){
        System.out.println(member);
        if(bindingResult.hasErrors()){
            throw new DataValidationException(bindingResult.getFieldError().getDefaultMessage());
        }
        Member member1=new Member();
        BeanUtils.copyProperties(member,member1);
        if(memberService.add(member1)!=null){
            return "redirect:/index/toIndex";
        }else{
            return "redirect:/index/toIndex";
        }
    }
    @RequestMapping("toIndex")
    public String toIndex(){
        return "/index2.html";
    }


    @ApiOperation(value = "修改会员", notes = "根据id修改会员")
    @ApiImplicitParam(name = "member", value = "会员对象", required = true, dataType = "MemberForm")
    @PostMapping("update")
    public String udpate(@Valid MemberForm member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new DataValidationException(bindingResult.getFieldError().getDefaultMessage());
        }
        Member member1=new Member();
        BeanUtils.copyProperties(member,member1);

        if(memberService.update(member1)>0){
            return "redirect:/index/toIndex";
        }else{
            return "redirect:/index/toIndex";
        }
    }
}
