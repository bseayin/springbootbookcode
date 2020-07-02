package com.zz.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.user.entity.SysPermissions;
import com.zz.user.entity.SysUsers;
import com.zz.user.service.SysPermissionsService;
import com.zz.util.KeyUtil;
import com.zz.util.MD5Utils;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/permissions")
public class SysPermissionsController {
    @Resource
    SysPermissionsService sysPermissionsService;

    @GetMapping("/")
    public String list() {
        return "permissionmanager.html";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResultVO add(SysPermissions sysPermissions) {
        sysPermissions.setId(KeyUtil.genUniqueKeyLong());
        System.out.println(sysPermissions);
        sysPermissionsService.save(sysPermissions);
        return ResultVOUtil.success();
    }

    @GetMapping("/list/{pageNo}/{pageSize}")
    @ResponseBody
    public ResultVO listData(@PathVariable("pageNo") String pageNo ,@PathVariable("pageSize") String pageSize) {
        Page<SysPermissions> page=new Page<SysPermissions>(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        return ResultVOUtil.success( sysPermissionsService.findByPage(page));
    }





}

