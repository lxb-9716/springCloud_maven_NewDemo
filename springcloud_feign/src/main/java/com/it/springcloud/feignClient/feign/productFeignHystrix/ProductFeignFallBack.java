package com.it.springcloud.feignClient.feign.productFeignHystrix;

import com.it.springcloud.common.page.basicPage.Page;
import com.it.springcloud.common.request.RequestBussiness;
import com.it.springcloud.common.response.ResponseBusinessPage;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.common.response.basicRes.CommonCode;
import com.it.springcloud.feignClient.feign.productFeign.ProductFeignClient;
import com.it.springcloud.model.productVO.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Component
@RequestMapping("/productFeignFullBack")
public class ProductFeignFallBack implements ProductFeignClient {

    @Override
    public ResponseResult save(RequestBussiness<Product> requestBussiness) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(CommonCode.FAIL.code());
        responseResult.setMessage("调用远程的保存商品方法失败！！！");
        return responseResult;
    }

    @Override
    public ResponseResult deleteProductById(Integer id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(CommonCode.FAIL.code());
        responseResult.setMessage("调用远程的根据id删除商品方法失败！！！");
        return responseResult;
    }

    @Override
    public ResponseBusinessPage<Page<Product>> findAllProductPage(int page, int size) {
        ResponseBusinessPage<Page<Product>> businessPage = new ResponseBusinessPage<>();
        businessPage.setCode(CommonCode.FAIL.code());
        businessPage.setMessage("调用远程的查询所有商品信息方法失败！！！");
        return businessPage;
    }
}
