package com.zz.form;

import lombok.Data;

/**
 * Created by Bsea
 * 2019-07-23 21:43
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
