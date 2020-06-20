package com.xsz.vote.controller;


import com.xsz.vote.entity.TUser;
import com.xsz.vote.service.TUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@Api(value = "用户Controller")
@RestController
@RequestMapping("user")
public class TUserController {
    @Resource
    TUserService tUserService;

    /**
     *  返回所有用户数据
     * @return
     */
    @GetMapping("all")
    public List<TUser> showAll(){
     return tUserService.list() ;
    }

}

