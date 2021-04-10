package com.zz.wechatshop.test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DummyXSZAPIResponse {
    /**
     * https://api.it120.cc/fireshop/shop/goods/category/all
     * {"icon":"","id":29476,"isUse":true,"key":"3","level":1,
     * "name":"潮流女装","paixu":0,"pid":0,"shopId":0,"type":"","userId":9436}
     * @return
     */
    public ArrayList<Category> getCategory(){
        ArrayList<Category> arrayList=new ArrayList();
        Category category=new Category();
        category.setId(29476);
        category.setKey("3");
        category.setName("潮流女装");
        category.setLevel(1);
        category.setUserId(9436);
        category.setUse(true);
        category.setPid(0);
        category.setShopId(0);
        category.setPaixu(0);
        arrayList.add(category);

        /**
         * {"icon":"https://dcdn.it120.cc/2020/03/14/f1eb3682-e4b0-4b13-8330-13f1ea35de9b.png","id":29588,
         * "isUse":true,
         * "key":"qdzq","level":2,"name":"童装","paixu":0,"pid":29476,"shopId":0,"type":"","userId":9436},
         */
        Category category2=new Category();
        category2.setIcon("https://dcdn.it120.cc/2020/03/14/f1eb3682-e4b0-4b13-8330-13f1ea35de9b.png");
        category2.setId(29588);
        category2.setKey("qdzq");
        category2.setName("童装");
        category2.setLevel(2);
        category2.setUserId(9436);
        category2.setUse(true);
        category2.setPid(29476);
        category2.setShopId(0);
        category2.setPaixu(0);
        arrayList.add(category2);
        return arrayList;

    }
}
