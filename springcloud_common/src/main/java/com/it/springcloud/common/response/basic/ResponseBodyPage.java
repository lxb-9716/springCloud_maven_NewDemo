package com.it.springcloud.common.response.basic;

import com.it.springcloud.common.page.productPage.ProductPage;

public class ResponseBodyPage<T> extends RespBody {

    public ResponseBodyPage() {
    }

    public ProductPage<T> getProductPage() {
        return productPage;
    }

    public void setProductPage(ProductPage<T> productPage) {
        this.productPage = productPage;
    }

    private ProductPage<T> productPage;

}
