package com.it.springcloud.feignClient.feign.product;

import com.it.springcloud.api.product.ProductApi;
import com.it.springcloud.feignClient.feign.productFeignHystrix.ProductFeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;

//当feign远程调用接口方法失败的时候，会进行回调ProductFeignClientHystrix类中的方法
@FeignClient(value = "spring-cloud-swagger-data", fallback = ProductFeignFallBack.class)
public interface ProductFeignClient extends ProductApi {

}
