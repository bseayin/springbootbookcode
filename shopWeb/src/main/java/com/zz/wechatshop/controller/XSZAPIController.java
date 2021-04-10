package com.zz.wechatshop.controller;

import com.zz.common.utils.Query;
import com.zz.common.utils.StringUtils;
import com.zz.shop.domain.ShopOrderWithProductInfo;
import com.zz.shop.domain.ShopProductDO;
import com.zz.system.service.UserService;
import com.zz.util.InfoResultVOUtil;
import com.zz.vo.InfoResultVO;
import com.zz.wechatshop.domain.Order;
import com.zz.wechatshop.domain.OrderProduct;
import com.zz.wechatshop.service.CategoryService;
import com.zz.wechatshop.service.OrderService;
import com.zz.wechatshop.service.ShopProductService;
import com.zz.wechatshop.test.DummyXSZAPIResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 微信小程序 API
 * By Bsea  2021/02/21
 */
@RestController
@RequestMapping("/xsz/api")
@Slf4j
public class XSZAPIController {
    @Resource
    DummyXSZAPIResponse dummyXSZAPIResponse;
    @Resource
    CategoryService categoryService;
    @Resource(name="wechatshop_shopProductServiceImpl")
    ShopProductService productService;
    @Resource
    OrderService orderService;
    @Resource
    UserService userService;

    // 顶部类型列表
    @RequestMapping("/shop/goods/category/all")
    public InfoResultVO getCategory(){

//        return   InfoResultVOUtil.success(dummyXSZAPIResponse.getCategory());
        return   InfoResultVOUtil.success(categoryService.getAllCategoryList());

    }
    // 商品详情   https://api.it120.cc/fireshop/shop/goods/detail?id=115272
    @RequestMapping("/shop/goods/detail")
    public InfoResultVO getProductInfo(String id){
        return   InfoResultVOUtil.success(productService.getProductInfo(id));

    }


    // 商品列表   https://api.it120.cc/fireshop/shop/goods/list

    /***
     *
     * @param categoryId 分类id 可为空
     * @param offset 分页偏移量  默认0
     * @param limit  分页条数 默认10
     * @return
     */
    @RequestMapping("/shop/goods/list")
    public InfoResultVO getProductList(@RequestParam(required = false) String categoryId,
                                       @RequestParam(defaultValue="0") int offset,
                                       @RequestParam(defaultValue="10") int limit){
        Map<String, Object> params = new HashMap<>();
        params.put("searchCategoryId", categoryId);
        params.put("offset", offset);
        params.put("limit", limit);
        params.put("isActive", true);
        Query query = new Query(params);
        return   InfoResultVOUtil.success(productService.listSimple(query));

    }

    @RequestMapping("/order/create")
    public InfoResultVO orderCreate(String userId, Order order,
                                    @RequestParam(required = false) Boolean calculate) {
        String productsStr = order.getGoodsJsonStr();
        if (StringUtils.isBlank(productsStr)) {
            InfoResultVOUtil.error(500, "商品列表为空");
        }
        Map<String, Object> params = new HashMap<>();
        JSONArray array = JSONArray.fromObject(productsStr);
        List<?> list2 = JSONArray.toList(array, new OrderProduct(), new JsonConfig());

        if (calculate != null && calculate) {//仅计算
            double amountTotle = 0;
            for (OrderProduct tempP : (List<OrderProduct>) list2) {
                ShopProductDO productDO = productService.get(tempP.getGoodsId());
                amountTotle += tempP.getNumber() * (productDO.getSales() == 0 ? productDO.getPrice() : productDO.getSales());
            }

            Map<String, Object> re = new HashMap<>();
            re.put("amountLogistics", 0);
            re.put("amountTotle", amountTotle);
            re.put("isNeedLogistics", 0);
            re.put("yunPrice", 0);

            return InfoResultVOUtil.success(re);

        } else {
            List<ShopOrderWithProductInfo> productList = orderService.addByProductIds(userId, order.getRemark(), (List<OrderProduct>) list2);

            double amountTotle = 0;
            for (ShopOrderWithProductInfo tempP : productList) {
                amountTotle += tempP.getMount() * tempP.getPrice();
            }
            Map<String, Object> re = new HashMap<>();
            re.put("amountLogistics", 0);
            re.put("amountTotle", amountTotle);
            re.put("isNeedLogistics", 0);
            re.put("yunPrice", 0);
            re.put("orderNumber", productList.get(0).getOrderSetId());
            re.put("amountReal", amountTotle);
            re.put("id", productList.get(0).getOrderSetId());

            return InfoResultVOUtil.success(re);
        }
    }

}
