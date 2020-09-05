package com.xsz.product.dao;

import com.xsz.common.config.MyMapper;
import com.xsz.product.domain.Product;

import java.util.List;

public interface ProductMapper extends MyMapper<Product> {
    List<Product> findProduct(Product product);

//    int deleteByPrimaryKey(Long productId);

//    int insert(Product record);
//
//    int insertSelective(Product record);
//
////    Product selectByPrimaryKey(Long productId);
//
////    List<Product> selectAll();
//
//    int updateByPrimaryKeySelective(Product record);
//
//    int updateByPrimaryKey(Product record);
}