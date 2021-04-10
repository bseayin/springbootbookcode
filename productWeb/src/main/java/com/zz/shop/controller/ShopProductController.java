package com.zz.shop.controller;

import com.zz.shop.dao.ShopCartDao;
import com.zz.shop.dao.ShopProductImageDao;
import com.zz.shop.domain.ShopCartDO;
import com.zz.shop.domain.ShopCartWithProductInfo;
import com.zz.shop.domain.ShopOrderDO;
import com.zz.shop.domain.ShopOrderWithProductInfo;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.domain.ShopProductEpisodeDO;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shop.service.ShopCartService;
import com.zz.shop.service.ShopOrderService;
import com.zz.shop.service.ShopProductService;
import com.zz.shop.vo.CategoryWithProductVO;
import com.zz.system.dao.UserDao;
import com.zz.system.domain.UserDO;
import com.zz.system.service.UserService;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import com.zz.xsz.domain.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/shop/product")
@RestController
public class ShopProductController {

  public static final int pageSize = 6;
  @Autowired
  ShopProductService productService;

  @Autowired
  ShopCartService shopCartService;

  @Autowired
  ShopOrderService shopOrderService;

  @Autowired
  UserService userService;

  @ResponseBody
  @GetMapping("/getProductByCategory")
  public ResultVO<Map> getProductByCategory(@RequestParam String categoryId, @RequestParam int count) {
    List<ShopProductDO> categoryList = productService.getProductByCategory(categoryId, count);
    return ResultVOUtil.success(categoryList);
  }
  @ResponseBody
  @GetMapping("/list")
  public ResultVO<Map> list(String categoryId, int page) {
    Map<String, Object> cateProductResult = productService.getProductByCategory(categoryId, pageSize, page * pageSize);
    return ResultVOUtil.success(cateProductResult);
  }
  @ResponseBody
  @GetMapping("/categoryWithProduct")
  public ResultVO<Map> categoryWithProduct(@RequestParam int categoryCount, @RequestParam int productCountInEachCategory) {
    List<CategoryWithProductVO> categoryList = productService.getProductByCategoryList(categoryCount, productCountInEachCategory);
    for(CategoryWithProductVO vo : categoryList) {
      productService.populateProductImage(vo.getProductList());
    }
    return ResultVOUtil.success(categoryList);
  }
  @ResponseBody
  @GetMapping("/product")
  public ResultVO<Map> list(String productId) {
    ShopProductDO productDetail = productService.getProductDetail(productId);
    List<ShopProductImageDO> productImageList = productService.getProductCarouselImage(productId);
    Map<String, List<ShopProductEpisodeDO>> epMap = productService.getProductEpisode(productId);
    int browsedCount = productService.getProductBrowseCount(productId);
    Map<String, Object> result = new HashMap<>();
    result.put("productInfo", productDetail);
    result.put("carouselImageList", productImageList);
    result.put("productEp", epMap);
    result.put("browsedCount", browsedCount);
    return ResultVOUtil.success(result);
  }

  @ResponseBody
  @PostMapping("/updateProductFavor")
  public ResultVO<Map> productFavor(String productId, String userId, boolean isFavor) {
    productService.updateUserProductFavor(productId, userId, isFavor);
    return ResultVOUtil.success();
  }

  @ResponseBody
  @GetMapping("/isProductFavor")
  public ResultVO<Map> isProductFavor(String productId, String userId) {
    boolean isFavor = productService.isUserFavorTheProduct(productId, userId);
    Map<String, Object> result = new HashMap<>();
    result.put("isFavor", isFavor);
    return ResultVOUtil.success(result);
  }

  @ResponseBody
  @GetMapping("/getUserCartList")
  public ResultVO<Map> getUserCartList(String userId) {
    List<ShopCartWithProductInfo> cartList = shopCartService.getUserCartList(userId);
    return ResultVOUtil.success(cartList);
  }

  @ResponseBody
  @PostMapping("/addToCart")
  public ResultVO<Map> addToCart(@RequestParam(name = "userId") String userId, @RequestParam(name = "productId")String productId, @RequestParam(name = "mount")Integer mount) {
    ShopCartDO cart = new ShopCartDO();
    cart.setUserId(userId);
    cart.setProductId(productId);
    cart.setMount(mount);
    shopCartService.addToCart(cart);
    return ResultVOUtil.success();
  }

  @ResponseBody
  @PostMapping("/updateCartMount")
  public ResultVO<Map> updateCartMount(String userId, String productId, Integer mount) {
    shopCartService.updateCartItemMount(userId, productId, mount);
    return ResultVOUtil.success();
  }

  @ResponseBody
  @PostMapping("/deleteFromCart")
  public ResultVO<Map> deleteFromCart(String userId, String productId, Integer mount) {
    ShopCartDO cart = new ShopCartDO();
    cart.setUserId(userId);
    cart.setProductId(productId);
    shopCartService.deleteFromCart(cart);
    return ResultVOUtil.success();
  }
  @ResponseBody
  @PostMapping("/addOrderFromCart")
  public ResultVO<Map> addOrderFromCart(String userId, String comments, String cartIdListStr) {
    List<String> cartIdList = Arrays.asList(cartIdListStr.split(","));
    if (cartIdList.size() < 1 ) {
      return ResultVOUtil.error(1, "没有选中任何产品");
    }
    List<ShopOrderWithProductInfo> orderInfo =  shopOrderService.addFromCart(userId, comments, cartIdList);
    String orderSetId = orderInfo.get(0).getOrderSetId();
    return ResultVOUtil.success(orderSetId);
  }

  @ResponseBody
  @PostMapping("/confirmOrder")
  public ResultVO<Map> addOrderFromCart(String orderSetId, String comments) {
    shopOrderService.updateOrderStatusFromCreateToConfirmed(orderSetId, comments);
    return ResultVOUtil.success(orderSetId);
  }

  @ResponseBody
  @PostMapping("/orderNow")
  public ResultVO<Map> orderNow(String userId, String productIdListStr) {
    if(productIdListStr != null) {
      String[] productIdList = productIdListStr.split(",");
      List<ShopOrderWithProductInfo> orderList = shopOrderService.orderNow(userId, Arrays.asList(productIdList));
      return ResultVOUtil.success(orderList);
    }
    return ResultVOUtil.error(1, "product ID is empty");
  }

  @ResponseBody
  @GetMapping("/getOrderInfo")
  public ResultVO<Map> getOrderInfo(String userId, String orderSetId) {
    List<ShopOrderWithProductInfo> orderList = shopOrderService.getOrderListByOrderSetId(userId, orderSetId);
    float totalPrice = 0;
    for (ShopOrderWithProductInfo productInfo: orderList) {
      if (productInfo.getStatus() != 1) {
        return ResultVOUtil.error(1, "错误的订单，请重新下单");
      }
      totalPrice += productInfo.getDisplayPrice() * productInfo.getMount();
    }
    Map<String, Object> results = new HashMap<>();
    UserDO user = userService.get(Long.valueOf(userId));
    results.put("orderList", orderList);
    results.put("totalPrice", totalPrice);
    results.put("user", user);
    return ResultVOUtil.success(results);
  }

  @ResponseBody
  @GetMapping("/getPaymentInfo")
  public ResultVO<Map> getPaymentInfo(String userId, String orderSetId) {
    List<ShopOrderWithProductInfo> orderList = shopOrderService.getOrderListByOrderSetId(userId, orderSetId);
    float totalPrice = 0;
    for (ShopOrderWithProductInfo productInfo: orderList) {
      if (productInfo.getStatus() != 2) {
        return ResultVOUtil.error(1, "错误的订单，请重新下单");
      }
      totalPrice += productInfo.getDisplayPrice() * productInfo.getMount();
    }
    Map<String, Object> results = new HashMap<>();
    UserDO user = userService.get(Long.valueOf(userId));
    results.put("orderList", orderList);
    results.put("totalPrice", totalPrice);
    results.put("user", user);
    return ResultVOUtil.success(results);
  }

  @ResponseBody
  @GetMapping("/getOrders")
  public ResultVO<Map> getOrders(String userId, int status, String from, String pageSize) {
    int fromInt = Integer.parseInt(from);
    int pageSizeInt = Integer.parseInt(pageSize);
    Map<String, List<ShopOrderWithProductInfo>> orderMap = shopOrderService.getOrderGroupByOrderSet(userId, status, fromInt, pageSizeInt);

    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("orders", orderMap);
    resultMap.put("orderSet", new HashMap<String, Object>());
    return ResultVOUtil.success(resultMap, fromInt + pageSizeInt, true );
  }

}
