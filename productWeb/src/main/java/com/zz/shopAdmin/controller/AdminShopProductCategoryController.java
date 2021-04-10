package com.zz.shopAdmin.controller;

import com.zz.common.domain.Tree;
import com.zz.common.utils.PageUtils;
import com.zz.common.utils.Query;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shopAdmin.service.AdminShopProductCategoryService;
import com.zz.shopAdmin.utils.FlagUtils;
import com.zz.system.domain.MenuDO;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/shop/category")
@Controller
public class AdminShopProductCategoryController {
  @Autowired
  AdminShopProductCategoryService adminShopProductCategoryService;

  @RequiresPermissions("shop:category:category")
  @GetMapping()
  String category(){
    return "shop/productcategory/productcategory";
  }

  @RequiresPermissions("shop:category:category")
  @GetMapping("select")
  String select(){
    return "shop/productcategory/productcategory_select";
  }
  @RequiresPermissions("shop:category:edit")
  @GetMapping("batchUpdate")
  String batchUpdate(){
    return "shop/productcategory/batchUpdate";
  }

  @RequiresPermissions("shop:category:add")
  @GetMapping("add/{pid}")
  String add(@PathVariable String pid, Model model){
    if (pid == FlagUtils.Category_Root_Id) {
      model.addAttribute("pid", pid);
      model.addAttribute("pidName", FlagUtils.Category_Root_Name);
    } else {
      ShopProductCategoryDO category= adminShopProductCategoryService.get(pid);
      model.addAttribute("pid", category.getId());
      model.addAttribute("pidName", category.getName());
    }
    return "shop/productcategory/add";
  }
  @RequiresPermissions("shop:category:add")
  @GetMapping("add")
  String addFirst( Model model){
      model.addAttribute("pid", FlagUtils.Category_Root_Id);
      model.addAttribute("pidName", FlagUtils.Category_Root_Name);
    return "shop/productcategory/add";
  }
  @RequiresPermissions("shop:category:edit")
  @GetMapping("edit/{id}")
  String edit(@PathVariable String id, Model model){
    ShopProductCategoryDO categoryDO= adminShopProductCategoryService.get(id);
    model.addAttribute("productcategory", categoryDO);
    if(FlagUtils.Category_Root_Id==categoryDO.getPid()){
      model.addAttribute("parentName",FlagUtils.Category_Root_Name);
    }else{
      model.addAttribute("parentName", adminShopProductCategoryService.get(categoryDO.getPid()).getName());
    }
    return "shop/productcategory/edit";
  }

  @RequiresPermissions(value={"shop:category:add","shop:category:edit"},logical = Logical.OR)
  @ResponseBody
  @PostMapping("/save")
  ResultVO save(ShopProductCategoryDO shopProductCategoryDO) {
    int count=-1;
    if (shopProductCategoryDO.getPid() == null || shopProductCategoryDO.getPid().trim().equals("")) {
      shopProductCategoryDO.setPid(null);
    }
    if (shopProductCategoryDO.getId() ==null) {
      count = adminShopProductCategoryService.save(shopProductCategoryDO);
    } else {
      count = adminShopProductCategoryService.update(shopProductCategoryDO);
    }
    if (count>0) {
      Map p=new HashMap();
      p.put("categoryId", shopProductCategoryDO.getId());
      return ResultVOUtil.success(p);
    }
    return ResultVOUtil.error(-1,"操作失败");
  }
  @RequiresPermissions(value={"shop:category:remove"},logical = Logical.OR)
  @ResponseBody
  @PostMapping("/remove")
  ResultVO remove( String  id) {
    int count= adminShopProductCategoryService.remove(id);
    if (count>0) {
      return ResultVOUtil.success();
    }
    return ResultVOUtil.error(-1,"操作失败");
  }

  @ResponseBody
  @GetMapping("/list")
  public PageUtils list(@RequestParam Map<String, Object> params) {
    params.put("wallStatus",1);
    if(!params.containsKey("pid")|| StringUtils.isBlank((String)params.get("pid"))){
      params.put("isFirst",true);
    }
    Query query = new Query(params);
    List<ShopProductCategoryDO> reList = adminShopProductCategoryService.list(query);
    int total = adminShopProductCategoryService.count(query);
    com.zz.common.utils.PageUtils pageUtils = new PageUtils(reList, total);
    return pageUtils;
  }
}
