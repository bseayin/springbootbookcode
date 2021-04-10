package com.zz.shop.controller;

import com.zz.shop.domain.ShopCarouselDO;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.service.ShopCarouselService;
import com.zz.shop.service.ShopProductService;
import com.zz.shop.vo.CategoryWithProductVO;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/shop/carousel")
@RestController
public class ShopCarouselController {
  @Autowired
  ShopCarouselService carouselService;
  @ResponseBody
  @GetMapping("/getHomePageCarousel")
  public ResultVO<Map> getHomePageCarousel() {
    List<ShopCarouselDO> carouselList = carouselService.getHomepageCarousel();
    return ResultVOUtil.success(carouselList);
  }
}
