package com.it.springcloud.swagger.controller.productController;

import com.it.springcloud.api.product.ProductApi;
import com.it.springcloud.common.request.ReqBody;
import com.it.springcloud.common.request.RequestBussiness;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.ResponseBusinessPage;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.common.response.basic.RespBody;
import com.it.springcloud.common.response.basicRes.CommonCode;
import com.it.springcloud.model.pojo.product.Product;
import com.it.springcloud.swagger.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController implements ProductApi {

    @Autowired
    private ProductService productService;
    @Autowired
    private HttpServletRequest request;

    /*保存商品用户信息*/
    public ResponseResult save(@RequestBody RequestBussiness<Product> requestBussiness) {
        ReqBody<Product> requestBody = requestBussiness.getRequestBody();
        Product data = requestBody.getData();
        Product product = productService.save(data);
        ResponseResult responseResult = new ResponseResult();
        if (null != product) {
            responseResult.setCode(CommonCode.SUCCESS.code());
            responseResult.setMessage(CommonCode.SUCCESS.message());
        } else {
            responseResult.setCode(CommonCode.FAIL.code());
            responseResult.setMessage(CommonCode.FAIL.message());
        }
        return responseResult;
    }

    /*根据id删除商品信息*/
    public ResponseResult deleteProductById(@PathVariable(value = "id", required = true) Integer id) {
        productService.deleteProductById(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /*查询所有商品的信息,带分页*/
    public ResponseBusinessPage<Product> findAllProductPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        String token = request.getHeader("token");
        System.out.println("token：" + token);
        String cookie = request.getHeader("cookie");
        System.out.println("cookie：" + cookie);
        Cookie[] cookies = request.getCookies();
        if (page <= 0) {
            page = 0;
        }
        if (page >= 1) {
            page = page - 1;
        }
        if (size <= 0) {
            size = 5;
        }
        return productService.findAllProductPage(page, size);
    }

    /*根据商品id查询商品信息*/
    public ResponseBusiness<Product> findProductById(@PathVariable("id") Integer id) {
        Product product = productService.findProductById(id);
        ResponseBusiness<Product> responseBusiness = new ResponseBusiness<>();
        RespBody<Product> responseBody = new RespBody<>();
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        if (null != product) {
            responseBody.setData(productList);
            responseBusiness.setResponseBody(responseBody);
            responseBusiness.setCode(CommonCode.SUCCESS.code());
            responseBusiness.setMessage(CommonCode.SUCCESS.message());
        } else {
            responseBusiness.setCode(CommonCode.FAIL.code());
            responseBusiness.setMessage(CommonCode.FAIL.message());
        }
        return responseBusiness;
    }

}
