package com.zz.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.user.entity.SysRoles;
import com.zz.user.service.SysRolesService;
import com.zz.util.KeyUtil;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "角色Controller")
@Controller
@RequestMapping("/roles")
public class SysRolesController {
    @Resource
    SysRolesService sysRolesService;

    @GetMapping("/")
    public String list() {
        return "roleList.html";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResultVO add(SysRoles sysRoles) {
        sysRoles.setId(KeyUtil.genUniqueKeyLong());
        System.out.println(sysRoles);
        sysRolesService.save(sysRoles);
        return ResultVOUtil.success();
    }
    @ApiOperation(value = "分页获取角色列表", notes = "获取角色列表")
    @GetMapping("/list/{pageNo}/{pageSize}")
    @ResponseBody
    public ResultVO listData(@PathVariable("pageNo") String pageNo , @PathVariable("pageSize") String pageSize) {
        Page<SysRoles> page=new Page<SysRoles>(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        return ResultVOUtil.success( sysRolesService.findByPage(page));
    }
}

