package com.zz.shop.controller;

import com.zz.shop.domain.ShopProductCommentDO;
import com.zz.shop.service.ShopProductCommentService;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/api/v1/shop/comment")
@RestController
public class ShopProductCommentController {
  @Autowired
  ShopProductCommentService commentService;
  @ResponseBody
  @GetMapping("/productComment")
  public ResultVO<Map> getProductComment(@RequestParam String productId) {
    List<ShopProductCommentDO> commentList = commentService.getProductComment(productId);
    float count = commentService.getProductCommentCount(productId);
    float goodCount = commentService.getProductGoodCommentCount(productId);
    Map<String, Object> map = new HashMap<>();
    map.put("commentList", commentList);
    map.put("commentCount", count);
    map.put("goodCount", goodCount);
    map.put("goodRate", Math.floor(goodCount/count*100.0));
    map.put("user", null);
    return ResultVOUtil.success(map);
  }
}
