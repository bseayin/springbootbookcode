package com.xsz.product.controller;

import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.ResponseBo;
import com.xsz.product.domain.Category;

import com.xsz.product.dto.CategoryDTO;

import com.xsz.product.form.CategoryForm;

import com.xsz.product.service.CategoryService;
import com.xsz.system.domain.User;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
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
import java.text.ParseException;
import java.util.Map;

/**
 * @Description: 菜品父类Controller
 * @Author: llf
 * @CreateDate: 2020/5/20 21:07
 */
@Controller
@RequestMapping("category")
public class CategoryController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CategoryService categoryService;


    @PostMapping("category")
    @RequiresPermissions("category:list")
    public String index() {
        return "product/category";
    }


    @Log("获取菜品父类信息分页")
    @GetMapping("categoryListPage")
    @RequiresPermissions("category:list")
    @ApiOperation(value = "获取菜品父类信息")
    @ResponseBody
    public Map<String, Object>categoryListPage(QueryRequest request, CategoryForm categoryForm) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        CategoryDTO categoryDTO=mapper.map(categoryForm,CategoryDTO.class);
        // 传入店铺id
        User user = super.getCurrentUser();
        categoryDTO.setCategoryCompanyid(user.getDeptId());
        return super.selectByPageNumSize(request, () -> this.categoryService.getCategoryListPage(request,categoryDTO));
    }

    @Log("根据店铺id获取菜品父类信息不分页")
    @GetMapping("categoryList")
    @ApiOperation(value = "根据店铺id获取菜品父类信息")
    @ResponseBody
    public ResponseBo categoryList() {
        // 传入店铺id
        User user = super.getCurrentUser();
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setCategoryCompanyid(user.getDeptId());
        return ResponseBo.ok(categoryService.getCategoryList(categoryDTO));
    }

    @Log("根据菜品id获取菜品父类信息不分页")
    @GetMapping("categoryListByDishes/{dishesId}")
    @ApiOperation(value = "根据菜品id获取菜品父类信息")
    @ResponseBody
    public ResponseBo categoryListByDishes(@PathVariable Long dishesId) {
        return ResponseBo.ok(categoryService.findCategoryListByDishes(dishesId));
    }

    @ApiOperation(value = "查看菜品父类详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "菜品父类Id", paramType = "path")
    })
    @Log("查看菜品父类详细信息")
    @RequiresPermissions("category:list")
    @GetMapping("getCategory/{categoryId}")
    @ResponseBody
    public ResponseBo getCategory(@PathVariable("categoryId") Long categoryId) {
        try {
            Category category=categoryService.getCategory(categoryId);
            return ResponseBo.ok(category);
        } catch (Exception e) {
            log.error("查看菜品父类详细信息失败", e);
            return ResponseBo.error("查看菜品父类详细信息失败，请联系网站管理员！");
        }
    }


    @Log("新增菜品父类")
    @RequiresPermissions("category:add")
    @PostMapping("categoryAdd")
    @ApiOperation(value = "新增菜品父类")
    @ResponseBody
    public ResponseBo categoryAdd(@RequestBody @Validated(CategoryForm.Create.class)CategoryForm categoryForm) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        CategoryDTO categoryDTO=mapper.map(categoryForm,CategoryDTO.class);
        try {
            User user = super.getCurrentUser();
            categoryDTO.setCreateman(user.getUserId());
            categoryDTO.setUpdateman(user.getUserId());
            categoryService.addCategory(categoryDTO);
            return ResponseBo.ok("新增菜品分类成功！");
        } catch (Exception e) {
            log.error("新增菜品父类失败", e);
            return ResponseBo.error("新增菜品分类失败，请联系系统管理员！");
        }
    }

    @Log("修改菜品父类")
    @RequiresPermissions("category:update")
    @PostMapping("categoryUpdate")
    @ApiOperation(value = "修改菜品父类")
    @ResponseBody
    public ResponseBo categoryUpdate(@RequestBody @Validated(CategoryForm.Update.class)CategoryForm categoryForm) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        CategoryDTO categoryDTO=mapper.map(categoryForm,CategoryDTO.class);
        try {
            User user = super.getCurrentUser();
            categoryDTO.setUpdateman(user.getUserId());
            categoryService.updateCategory(categoryDTO);
            return ResponseBo.ok("修改菜品分类成功！");
        } catch (Exception e) {
            log.error("修改菜品父类失败", e);
            return ResponseBo.error("修改菜品分类失败，请联系系统管理员！");
        }
    }

    @ApiOperation(value = "删除菜品父类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "菜品父类Id", paramType = "path")
    })
    @Log("删除菜品父类")
    @RequiresPermissions("category:delete")
    @PostMapping("categoryDelete/{categoryId}")
    @ResponseBody
    public ResponseBo categoryDelete(@PathVariable("categoryId") Long categoryId) {
        try {
            int num=categoryService.deleteCategory(categoryId);
            if(num==0){
                return ResponseBo.ok("删除菜品成功！");
            }
            return ResponseBo.ok("该菜品分类下含有菜品信息，不可删除");
        } catch (Exception e) {
            log.error("删除菜品失败", e);
            return ResponseBo.error("删除菜品失败，请联系系统管理员！");
        }
    }

}
