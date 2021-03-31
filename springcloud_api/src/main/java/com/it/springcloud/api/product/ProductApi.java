package com.it.springcloud.api.product;

import com.it.springcloud.common.request.RequestBussiness;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.ResponseBusinessPage;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.model.pojo.jpa.product.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "商品信息管理接口", description = "商品信息的增加、删除、修改、查询")
@RequestMapping("/product")
public interface ProductApi {

    /*保存商品用户信息*/
    @ApiOperation("保存商品信息")
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public ResponseResult save(@RequestBody RequestBussiness<Product> requestBussiness);

    /*根据id删除商品信息*/
    @ApiOperation("根据id删除商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品主键id", required = true,
                    paramType = "path", dataType = "int"),
    })
    @GetMapping(value = "/deleteProductById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseResult deleteProductById(@PathVariable(value = "id", required = true) Integer id);

    /*查询所有商品的信息,带分页*/
    @ApiOperation("查询所有商品的信息,带分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true,
                    paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true,
                    paramType = "path", dataType = "int")
    })
    @GetMapping("/findAllProductPage/{page}/{size}")
    public ResponseBusinessPage<Product> findAllProductPage(@PathVariable("page") int page, @PathVariable("size") int size);

    /*根据商品id查询商品信息*/
    @ApiOperation("根据id查询商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true,
                    paramType = "path", dataType = "int")
    })
    @GetMapping(value = "/findProductById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Product> findProductById(@PathVariable("id") Integer id);
}
