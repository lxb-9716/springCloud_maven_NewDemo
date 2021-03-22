package com.it.springcloud.swagger.repository.productRepository;

import com.it.springcloud.model.pojo.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
