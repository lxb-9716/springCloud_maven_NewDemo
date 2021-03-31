package com.it.springcloud.feignClient.controller;

import com.it.springcloud.common.request.RequestBussiness;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.ResponseBusinessPage;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.feignClient.feign.product.ProductFeignClient;
import com.it.springcloud.model.pojo.jpa.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productFeignClient")
public class ProductFeignController {

    @Value("${version}")
    private String version;

    @GetMapping("/testConfig")
    public String testConfig() {
        System.out.println("version：" + version);
        return "version：" + version;
    }

    @Autowired
    private ProductFeignClient productFeignClient;

    /*保存商品用户信息*/
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public ResponseResult save(@RequestBody RequestBussiness<Product> requestBussiness) {
        return productFeignClient.save(requestBussiness);
    }

    /*根据id删除商品信息*/
    @GetMapping(value = "/deleteProductById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseResult deleteProductById(@PathVariable(value = "id", required = true) Integer id) {
        return productFeignClient.deleteProductById(id);
    }

    /*查询所有商品的信息,带分页*/
    @GetMapping("/findAllProductPage/{page}/{size}")
    public ResponseBusinessPage<Product> findAllProductPage(@PathVariable(value = "page", required = true) int page, @PathVariable(value = "size", required = true) int size) {
        return productFeignClient.findAllProductPage(page, size);
    }

    @GetMapping(value = "/findProductById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Product> findProductById(@PathVariable("id") Integer id) {
        return productFeignClient.findProductById(id);
    }

}
