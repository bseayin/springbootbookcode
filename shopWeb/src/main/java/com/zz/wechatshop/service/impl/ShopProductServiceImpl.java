package com.zz.wechatshop.service.impl;

import com.zz.common.utils.DateUtils;
import com.zz.shop.dao.ShopUserBrowseProductHistoryDao;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shopAdmin.dao.AdminUserproductfavoriteDao;
import com.zz.shopAdmin.domain.ProductinproductcategoryDO;
import com.zz.shopAdmin.service.AdminProductImageService;
import com.zz.shopAdmin.service.AdminProductinproductcategoryService;
import com.zz.shopAdmin.service.AdminShopProductService;
import com.zz.wechatshop.service.ShopProductService;
import com.zz.wechatshop.vo.ProductBaseInfo;
import com.zz.wechatshop.vo.ProductPic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service(value="wechatshop_shopProductServiceImpl")
public class ShopProductServiceImpl implements ShopProductService {


  @Resource
  AdminShopProductService adminShopProductService;
  @Resource
  AdminProductImageService adminProductImageService;
  @Resource
  AdminProductinproductcategoryService adminProductinproductcategoryService;
  @Resource
  AdminUserproductfavoriteDao adminUserproductfavoriteDao;
  @Resource
  ShopUserBrowseProductHistoryDao shopUserBrowseProductHistoryDao;
  @Resource
  CategoryServiceImpl categoryServiceImpl;


  @Value("${ImageHost}")
  String imageHost;

  @Override
  public ShopProductDO get(String id){
    return adminShopProductService.get(id);
  }
  /***
   * @param id =shop_product.id
   * @return
   */
  @Override
  public Map<String, Object> getProductInfo(String id) {

    Map re=new HashMap();



    List<ProductPic> picList= adminProductImageService.list(id).stream().map((item) -> {
      ProductPic tempre= package_to_ProductPic(item);
      String temppic = tempre.getPic();
      tempre.setPic(imageHost + temppic);
      return tempre;
    }).collect(Collectors.toList());
    re.put("pics",picList);

    ShopProductDO product= adminShopProductService.get(id);
    if(picList.size()>0){
      re.put("pics2", picList.get(0).getPic());
      product.setImage( picList.get(0).getPic());
    }
    re.put("basicInfo",package_to_ProductBaseInfo(product));

    List<ProductinproductcategoryDO>  categoryList= adminProductinproductcategoryService.list(id);
    if(categoryList.size()>=1){
      ProductinproductcategoryDO ppd=categoryList.get(0);
      re.put("category", categoryServiceImpl.get(ppd.getProductCategoryId()));
    }

    re.put("content",product.getProductDetail());
    return re;
  }


  @Override
  public  List<ProductBaseInfo> listSimple(Map<String, Object> map) {
    return  adminShopProductService.listSimple(map).stream().map((item) -> {
      List<ShopProductImageDO>  imgeList=  adminProductImageService.list(item.getId());
      if(imgeList.size()>0){
        item.setImage( imageHost + imgeList.get(0).getImageSrc());
      }
      return package_to_ProductBaseInfo(item);
    }).collect(Collectors.toList());
  }

  public  ProductBaseInfo package_to_ProductBaseInfo(ShopProductDO pDo){
    ProductBaseInfo reVo=  new ProductBaseInfo();
    //---暂
    reVo.setAfterSale("0,1,2");
    reVo.setCategoryId("");
    reVo.setCommission(0);
    reVo.setCommissionType(0);
    reVo.setFxType(2);
    reVo.setGotScore(0);
    reVo.setGotScoreType(0);
    reVo.setHasAddition(false);
    reVo.setHidden(0);
    reVo.setLimitation(false);
    reVo.setLogisticsId(0);
    reVo.setMaxCoupons(0);
    reVo.setMiaosha(false);
    reVo.setMinBuyNumber(1);
    reVo.setMinScore(0);
    reVo.setNumberGoodReputation(0);
    reVo.setNumberOrders(0);
    reVo.setNumberSells(0);
    reVo.setOverseas(false);
    reVo.setPaixu(0);
    reVo.setPingtuan(false);
    reVo.setPingtuanPrice(pDo.getPrice());
    reVo.setRecommendStatus(1);
    reVo.setRecommendStatusStr("推荐");
    reVo.setSeckillBuyNumber(0);
    reVo.setSellStart(true);
    reVo.setSellEnd(false);
    reVo.setShopId(pDo.getCreatedBy());
    reVo.setUserId(pDo.getCreatedBy());
    reVo.setStatus(0);
    reVo.setStatusStr("上架");
    reVo.setStoreAlert(false);
    reVo.setStores0Unsale(false);
    reVo.setKanjia(false);
    reVo.setKanjiaPrice(0);
    reVo.setType(0);
    reVo.setViews(0);
    reVo.setWeight(0);

    //------------


    reVo.setId(pDo.getId());
    reVo.setMinPrice(pDo.getPrice());
    reVo.setName(pDo.getTitleShort());
    reVo.setOriginalPrice(pDo.getPrice());
    reVo.setStores(pDo.getTotalStock());
    reVo.setPic(pDo.getImage());

    reVo.setDateAdd(DateUtils.format(pDo.getCreatedTime(),DateUtils.DATE_TIME_PATTERN));
    reVo.setDateUpdate(DateUtils.format(pDo.getUpdatedTime(),DateUtils.DATE_TIME_PATTERN));

    Map tt=new HashMap();
    tt.put("active",1);
    tt.put("productId",pDo.getId());
    reVo.setNumberFav(adminUserproductfavoriteDao.count(tt));

    reVo.setViews(shopUserBrowseProductHistoryDao.get_product_browse_count(pDo.getId()));

    return reVo;
  }
  public  ProductPic package_to_ProductPic(ShopProductImageDO paiDo){
    ProductPic reVo=  new ProductPic();
    reVo.setPic(paiDo.getImageSrc());
    reVo.setId(paiDo.getId());
    reVo.setGoodsId(paiDo.getProductId());
    reVo.setUserId(paiDo.getCreatedBy());
    return reVo;
  }
}
