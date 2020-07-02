package com.zz.user.controller;


import com.zz.user.entity.SysPermissions;
import com.zz.user.entity.SysRolesPermissions;
import com.zz.user.service.SysPermissionsService;
import com.zz.user.service.SysRolesPermissionsService;
import com.zz.util.KeyUtil;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/rolespermissions")
public class SysRolesPermissionsController {
    @Resource
    SysRolesPermissionsService sysRolesPermissionsService;



    @PostMapping("/save")
    @ResponseBody
    public ResultVO add(SysRolesPermissions sysRolesPermissions) {

        System.out.println(sysRolesPermissions);
        sysRolesPermissionsService.save(sysRolesPermissions);
        return ResultVOUtil.success();
    }
}

