package com.it.springcloud.swagger.repository.product;

import com.it.springcloud.model.pojo.jpa.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
