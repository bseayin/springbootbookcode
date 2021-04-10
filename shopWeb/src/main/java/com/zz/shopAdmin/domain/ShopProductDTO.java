package com.zz.shopAdmin.domain;

import com.zz.shop.domain.ShopProductDO;
import lombok.Data;

@Data
public class ShopProductDTO extends ShopProductDO {
    String[] categoryIds;
    Integer favoriteNum;
    Integer browseNum;
}
