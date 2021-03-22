package com.it.springcloud.common.response;

import com.it.springcloud.common.response.basic.RespBody;

public class ResponseBusiness<T> extends ResponseResult {

    //响应体
    private RespBody<T> responseBody;

    public RespBody<T> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(RespBody<T> responseBody) {
        this.responseBody = responseBody;
    }
}
