package com.zz.shop.controller;

import com.zz.shop.domain.ShopCarouselDO;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shop.service.ShopProductCategoryService;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/shop/category")
@RestController
public class ShopProductCategoryController {
  @Autowired
  ShopProductCategoryService shopProductCategoryService;
  @ResponseBody
  @GetMapping("/contentOnMainPage")
  public ResultVO<Map> contentOnMainPage() {
    Map<String, Object> data = new HashMap();
    List<ShopProductCategoryDO> categoryList = shopProductCategoryService.getMainPageCategory();
    List<ShopCarouselDO> carouselList = shopProductCategoryService.getMainPageCarousel();
    data.put("carouselList", carouselList);
    data.put("categoryList", categoryList);
    return ResultVOUtil.success(data);
  }

  @ResponseBody
  @GetMapping("/getCategoryMap")
  public ResultVO<Map> getCategoryMap() {
    Map<ShopProductCategoryDO, List<ShopProductCategoryDO>> map = shopProductCategoryService.getCategoryMap();
    return ResultVOUtil.success(map);
  }

  @ResponseBody
  @GetMapping("/getAllCategory")
  public ResultVO<Map> getAllCategory() {
    List<ShopProductCategoryDO> allCategoryList = shopProductCategoryService.getAllCategoryList();
    return ResultVOUtil.success(allCategoryList);
  }
}
