package com.zz.service;

import com.zz.entity.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by Bsea
 * 2019-05-09 10:12
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
