package com.xsz.product.controller;

import com.alibaba.fastjson.JSON;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.ResponseBo;
import com.xsz.product.domain.Category;
import com.xsz.product.domain.DishesModel;
import com.xsz.product.dto.CategoryDTO;
import com.xsz.product.dto.DishesDTO;
import com.xsz.product.form.CategoryForm;
import com.xsz.product.form.DishesForm;
import com.xsz.product.service.CategoryService;
import com.xsz.product.service.DishesModelService;
import com.xsz.system.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description: 菜品规格父类Controller
 * @Author: llf
 * @CreateDate: 2020/6/1
 */
@Controller
@RequestMapping("dishes")
public class DishesModelController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DishesModelService dishesModelService;

    @Log("获取菜品规格信息分页")
    @GetMapping("dishesModelListPage/{dishesId}")
    @ApiOperation(value = "获取菜品规格信息分页")
    @ResponseBody
    public Map<String, Object> dishesModelListPage(QueryRequest request,@PathVariable("dishesId")Long dishesId) {
        return super.selectByPageNumSize(request, () -> this.dishesModelService.getDishesModelPage(request,dishesId));
    }


    @Log("新增菜品规格")
    @PostMapping("dishesModelAdd/{dishesId}")
    @ApiOperation(value = "新增菜品规格")
    @ResponseBody
    public ResponseBo dishesModelAdd(@PathVariable("dishesId") Long dishesId,@RequestBody String str) {
        try {
            List<DishesModel> dishesModelList = JSON.parseArray(JSON.parseObject(str).getString("dishesModelList"), DishesModel.class);
            dishesModelService.addOrUpdateDishesModel(dishesModelList,dishesId,true);
            return ResponseBo.ok("新增菜品规格成功！");
        } catch (Exception e) {
            log.error("新增菜品规格失败", e);
            return ResponseBo.error("新增菜品规格失败，请联系系统管理员！");
        }
    }

    @Log("修改菜品规格")
    @PostMapping("dishesModelUpdate/{dishesId}")
    @ApiOperation(value = "修改菜品规格")
    @ResponseBody
    public ResponseBo dishesModelUpdate(@PathVariable("dishesId") Long dishesId,@RequestBody String str) {
        try {
            List<DishesModel> dishesModelList = JSON.parseArray(JSON.parseObject(str).getString("dishesModelList"), DishesModel.class);
            dishesModelService.addOrUpdateDishesModel(dishesModelList,dishesId,false);
            return ResponseBo.ok("修改菜品规格成功！");
        } catch (Exception e) {
            log.error("修改菜品规格失败", e);
            return ResponseBo.error("修改菜品规格失败，请联系系统管理员！");
        }
    }

}
