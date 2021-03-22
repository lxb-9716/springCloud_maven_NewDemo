package com.it.springcloud.common.request;


public class RequestBussiness<T> {
    private ReqBody<T> requestBody;

    public ReqBody<T> getRequestBody() {
        return requestBody;
    }

    public RequestBussiness() {
    }

    public void setRequestBody(ReqBody<T> requestBody) {
        this.requestBody = requestBody;
    }

}
