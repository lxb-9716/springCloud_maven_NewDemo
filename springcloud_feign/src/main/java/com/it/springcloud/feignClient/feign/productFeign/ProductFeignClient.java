package com.it.springcloud.feignClient.feign.productFeign;

import com.it.springcloud.common.page.basicPage.Page;
import com.it.springcloud.common.request.RequestBussiness;
import com.it.springcloud.common.response.ResponseBusinessPage;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.feignClient.feign.productFeignHystrix.ProductFeignFallBack;
import com.it.springcloud.model.productVO.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//当feign远程调用接口方法失败的时候，会进行回调ProductFeignClientHystrix类中的方法
@FeignClient(value = "spring-cloud-swagger-data", fallback = ProductFeignFallBack.class)
@RequestMapping("/product")
public interface ProductFeignClient {
    /*保存商品用户信息*/
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public ResponseResult save(@RequestBody RequestBussiness<Product> requestBussiness);

    /*根据id删除商品信息*/
    @GetMapping(value = "/deleteById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseResult deleteProductById(@PathVariable(value = "id", required = true) Integer id);


    /*查询所有商品的信息,带分页*/
    @GetMapping("/findAllProductPage/{page}/{size}")
    public ResponseBusinessPage<Page<Product>> findAllProductPage(@PathVariable(value = "page", required = true) int page, @PathVariable(value = "size", required = true) int size);

}
