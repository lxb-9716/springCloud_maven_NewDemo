package com.it.springcloud.api.orders;


import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Orders;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "订单信息管理api", description = "学生信息的增加、删除、修改、查询")
@RequestMapping("/order")
public interface OrdersApi {

    /*根据商品id查询课程信息*/
    @ApiOperation("创建订单接口(注意在创建订单的同时商品库存数量也要相应的变化)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品id", required = true,
                    paramType = "path", dataType = "long"), @ApiImplicitParam(name = "count", value = "购买商品数量", required = true,
            paramType = "path", dataType = "long")
    })
    @GetMapping(value = "/createOrder/{goodsId}/{count}", produces = "application/json;charset=UTF-8")
    public ResponseResult createOrder(@PathVariable("goodsId") Long goodsId, @PathVariable("count") Long count);
}
