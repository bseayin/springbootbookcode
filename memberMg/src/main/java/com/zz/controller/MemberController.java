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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/10/13$ 11:22$
 */
@Api(value = "会员控制器")
@RestController
@RequestMapping("member")
public class MemberController {
    @Resource
    MemberService memberService;

    @ApiOperation(value = "查看会员", notes = "查看所有会员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "开始页0开始", required = true, dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", required = true, dataType = "int",paramType = "path"),
    })
    @GetMapping("showall/{page}/{size}")
    public Page<Member>  showAll(@PathVariable("page") int page, @PathVariable("size") int size){
//        FormUtil.filterBean();
        return memberService.showall(page,size);
    }

    @ApiOperation(value = "查看会员", notes = "根据名字查找会员")
    @ApiImplicitParam(name = "name", value = "会员名字", required = true, dataType = "String",paramType = "path")
    @GetMapping("show/{name}")
    public Member  showByName(@PathVariable("name") String name){
        return memberService.showByName(name);
    }

    @ApiOperation(value = "添加会员", notes = "根据名字查找会员")
    @ApiImplicitParam(name = "name", value = "会员名字", required = true, dataType = "String",paramType = "path")
    @PostMapping("add")
    public Member  add(@Valid MemberForm member, BindingResult bindingResult){
        System.out.println(member);
        if(bindingResult.hasErrors()){
            throw new DataValidationException(bindingResult.getFieldError().getDefaultMessage());
        }
        Member member1=new Member();
        BeanUtils.copyProperties(member,member1);
        return memberService.add(member1);
    }



}

