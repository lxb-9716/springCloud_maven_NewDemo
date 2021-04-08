package com.it.springcloud.swagger.controller.orders;

import com.it.springcloud.api.orders.OrdersApi;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.common.response.basicRes.CommonCode;
import com.it.springcloud.swagger.service.OrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController implements OrdersApi {
    @Autowired
    private OrderService orderService;

    /*根据商品id查询课程信息*/
    @Override
    public ResponseResult createOrder(@PathVariable("goodsId") Long goodsId, @PathVariable("count") Long count) {
        int i = orderService.createOrder(goodsId, count);
        ResponseResult responseResult = new ResponseResult();
        if (1 == i) {
            responseResult.setCode(CommonCode.SUCCESS.code());
            responseResult.setMessage(CommonCode.SUCCESS.message());
        } else {
            responseResult.setCode(CommonCode.FAIL.code());
            responseResult.setMessage(CommonCode.FAIL.message());
        }
        return responseResult;
    }
}
