package com.xsz.product.service.impl;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.impl.BaseService;
import com.xsz.product.domain.Product;
import com.xsz.product.dao.ProductMapper;
import com.xsz.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProductServiceImpl extends BaseService<Product> implements ProductService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ProductMapper productMapper;


    @Override
    public List<Product> findProduct(QueryRequest request, Product product) {
        return productMapper.findProduct(product);
    }
}
