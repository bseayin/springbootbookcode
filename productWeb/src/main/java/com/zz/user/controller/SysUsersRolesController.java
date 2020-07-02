package com.zz.user.controller;


import com.zz.user.entity.SysUsersRoles;
import com.zz.user.service.SysUsersRolesService;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bsea
 * @since 2019-12-25
 */
@Controller
@RequestMapping("/usersroles")
public class SysUsersRolesController {
    @Resource
    SysUsersRolesService sysUsersRolesService;



    @PostMapping("/save")
    @ResponseBody
    public ResultVO add(SysUsersRoles sysUsersRoles) {

        System.out.println(sysUsersRoles);
        sysUsersRolesService.save(sysUsersRoles);
        return ResultVOUtil.success();
    }
}

