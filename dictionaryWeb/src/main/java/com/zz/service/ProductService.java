package com.zz.service;

import com.zz.entity.Product;
import com.zz.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:  产品服务类
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
@Service
public class ProductService {
	@Resource
    ProductRepository productRepository;
	
	public List<Product> getAll(){
		
		return (List<Product>) productRepository.findAll();
	}
	
	
	
	
public List<Product> getByName(String name){
		
		return productRepository.findByProductName(name);
	}

public List<Product> getByLikeName(String name){
	
	return productRepository.findByProductNameLike(name);
}


public List<Product> getByNameAndPrice(String name, String price){
	
	return productRepository.findByProductNameAndProductPrice(name,price);
}





}
