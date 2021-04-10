package com.zz.shopAdmin.controller;

import com.zz.common.domain.Tree;
import com.zz.common.utils.PageUtils;
import com.zz.common.utils.Query;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shopAdmin.domain.ProductinproductcategoryDO;
import com.zz.shopAdmin.service.AdminProductinproductcategoryService;
import com.zz.shopAdmin.service.AdminShopProductCategoryService;
import com.zz.shopAdmin.utils.FlagUtils;
import com.zz.system.domain.MenuDO;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/shop/productInCategory")
@Controller
public class AdminShopProductinProductCategoryController {
  @Autowired
  AdminShopProductCategoryService adminShopProductCategoryService;
  @Autowired
  AdminProductinproductcategoryService adminProductinproductcategoryService;

  @GetMapping()
  String productInCategory(String productId,Model model){
    model.addAttribute("productId",productId);
    return "shop/productcategory/productcategory_treeselect";
  }

  @ResponseBody
  @GetMapping("/list/{productId}")
  ResultVO list(@PathVariable String productId, Model model){
    Map temp=new HashMap();
    temp.put("productId",productId);
    List<ProductinproductcategoryDO> tempCheckedList = adminProductinproductcategoryService.list(temp);
    Map re=new HashMap();
    re.put("categorys", tempCheckedList);
    return ResultVOUtil.success(re);
  }


  @GetMapping("/tree")
  @ResponseBody
  Tree<MenuDO> tree() {
    Tree<MenuDO>  tree = adminShopProductCategoryService.getTree(null);
    return tree;
  }

  @GetMapping("/tree/{productId}")
  @ResponseBody
  Tree<MenuDO> tree(@PathVariable("productId") String productId) {
    Tree<MenuDO> tree = adminShopProductCategoryService.getTree(productId);
    return tree;
  }
}
