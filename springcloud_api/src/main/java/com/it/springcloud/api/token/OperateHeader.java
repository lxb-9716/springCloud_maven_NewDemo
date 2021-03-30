package com.it.springcloud.api.token;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "处理请求头相关的API接口")
@RequestMapping("/OperateHeader")
public interface OperateHeader {

    @ApiOperation("生成token")
    @GetMapping(value = "/makeToken")
    public String makeToken();
}
