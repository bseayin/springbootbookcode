package com.zz.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Bsea
 * 2019-07-23 17:20
 */
@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
