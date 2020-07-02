package com.zz.repository;
/**
 * @Description:  产品
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
import com.zz.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
	
	public List<Product> findByProductName(String name);
	public List<Product> findByProductNameLike(String name);
	public List<Product> findByProductNameAndProductPrice(String name, String price);

	
	

}
