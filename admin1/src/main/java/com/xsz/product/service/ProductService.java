package com.xsz.product.service;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.IService;
import com.xsz.product.domain.Product;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames = "ProductService")
public interface ProductService extends IService<Product> {
    List<Product> findProduct(QueryRequest request, Product product);


}
