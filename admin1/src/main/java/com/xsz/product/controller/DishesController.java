package com.xsz.product.controller;

import com.xsz.common.annotation.Log;
import com.xsz.common.controller.BaseController;
import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.ResponseBo;
import com.xsz.product.domain.Dishes;
import com.xsz.product.dto.DishesDTO;
import com.xsz.product.form.DishesForm;
import com.xsz.product.service.DishesService;
import com.xsz.system.domain.User;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: 菜品Controller
 * @Author: llf
 * @CreateDate: 2020/5/20 21:07
 */
@Controller
@RequestMapping("dishes")
public class DishesController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DishesService dishesService;


    @Value("${file.upload.path}")
    String filePath;

    @Value("${file.upload.path.relative}")
    String filePathRelative;

    @PostMapping("dishes")
    @RequiresPermissions("dishes:list")
    public String index() {
        return "product/dishes";
    }


    @Log("获取菜品列表分页")
    @GetMapping("dishesList")
    @RequiresPermissions("dishes:list")
    @ApiOperation(value = "获取菜品列表分页")
    @ResponseBody
    public Map<String, Object> dishesList(QueryRequest request, DishesForm dishesForm) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        DishesDTO dishesDTO = mapper.map(dishesForm, DishesDTO.class);
        return super.selectByPageNumSize(request, () ->
                this.dishesService.getDishesPage(request, dishesDTO)
        );
    }

    @ApiOperation(value = "查看菜品详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dishesId", value = "菜品Id", paramType = "path")
    })
    @Log("查看菜品详细信息")
    @RequiresPermissions("dishes:list")
    @GetMapping("getDishes/{dishesId}")
    @ResponseBody
    public ResponseBo getDishes(@PathVariable("dishesId") Long dishesId) {
        try {
            Dishes dishes = dishesService.getDishesById(dishesId);
            return ResponseBo.ok(dishes);
        } catch (Exception e) {
            log.error("查看菜品详细信息失败", e);
            return ResponseBo.error("查看菜品详细信息失败，请联系网站管理员！");
        }
    }

    @ApiOperation(value = "新增菜品")
    @Log("新增菜品")
    @RequiresPermissions("dishes:add")
    @PostMapping("dishesAdd")
    @ResponseBody
    public ResponseBo dishesAdd(@RequestBody @Validated(DishesForm.Create.class) DishesForm dishesForm) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        DishesDTO dishesDTO = mapper.map(dishesForm, DishesDTO.class);
        try {
            User user = super.getCurrentUser();
            dishesDTO.setSpareCreateman(user.getUserId());
            dishesDTO.setSpareUpdateman(user.getUserId());
            Long id = dishesService.addDishes(dishesDTO, dishesForm.getCategoryIds());
            return ResponseBo.ok(id);
        } catch (Exception e) {
            log.error("新增菜品失败", e);
            return ResponseBo.error("新增菜品失败，请联系系统管理员！");
        }
    }

    @ApiOperation(value = "修改菜品")
    @Log("修改菜品")
    @RequiresPermissions("dishes:update")
    @PostMapping("dishesUpdate")
    @ResponseBody
    public ResponseBo dishesUpdate(@RequestBody @Validated(DishesForm.Update.class) DishesForm dishesForm) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        DishesDTO dishesDTO = mapper.map(dishesForm, DishesDTO.class);
        try {
            User user = super.getCurrentUser();
            dishesDTO.setSpareUpdateman(user.getUserId());
            dishesService.updateDishes(dishesDTO, dishesForm.getCategoryIds());
            return ResponseBo.ok("修改菜品成功！");
        } catch (Exception e) {
            log.error("修改菜品失败", e);
            return ResponseBo.error("修改菜品失败，请联系系统管理员！");
        }
    }

    @ApiOperation(value = "下架菜品")
    @Log("下架菜品")
    @RequiresPermissions("dishes:delete")
    @PostMapping("dishesDelete")
    @ResponseBody
    public ResponseBo dishesDelete(String ids) {
        try {
            User user = super.getCurrentUser();
            dishesService.deleteDishes(ids, user.getUserId());
            return ResponseBo.ok("菜品下架成功！");
        } catch (Exception e) {
            log.error("菜品下架失败", e);
            return ResponseBo.error("菜品下架失败，请联系系统管理员！");
        }
    }

    @ApiOperation(value = "上传菜品图片")
    @Log("上传菜品图片")
    @RequiresPermissions("dishes:file")
    @PostMapping("dishesFileUpload/{dishesId}")
    @ResponseBody
    public ResponseBo dishesFileUpload(@PathVariable("dishesId") Long dishesId, HttpServletRequest req, MultipartHttpServletRequest multiReq) {
        try {
            MultipartFile multipartFile = multiReq.getFile("photo");
            //获取原始图片的拓展名
            String originalFilename = multipartFile.getOriginalFilename();
            //新的文件名字
            String newFileName = UUID.randomUUID() + originalFilename;
            //封装上传文件位置的全路径
            File targetFile = new File(filePath, newFileName);
            // 把本地文件上传到封装上传文件位置的全路径
            multipartFile.transferTo(targetFile);
            User user = super.getCurrentUser();
            DishesDTO dishesDTO = new DishesDTO();
            dishesDTO.setSpareId(dishesId);
            dishesDTO.setSpareUpdateman(user.getUserId());
            dishesDTO.setSparePhoto(newFileName);
            dishesDTO.setPhotoPath(filePathRelative+newFileName);
            dishesService.updateDishesFile(dishesDTO);
            return ResponseBo.ok("上传菜品图片成功！");
        } catch (Exception e) {
            log.error("上传菜品图片失败", e);
            return ResponseBo.error("上传菜品图片失败，请联系系统管理员！");
        }
    }

}
