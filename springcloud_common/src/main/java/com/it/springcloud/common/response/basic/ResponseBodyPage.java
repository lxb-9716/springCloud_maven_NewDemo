package com.it.springcloud.common.response.basic;

import com.it.springcloud.common.page.Paging;

public class ResponseBodyPage<T> extends RespBody {

    public ResponseBodyPage() {
    }

    public Paging<T> getProductPage() {
        return productPage;
    }

    public void setProductPage(Paging<T> productPage) {
        this.productPage = productPage;
    }

    private Paging<T> productPage;

}
