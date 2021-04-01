package com.it.springcloud.common.response.basic;

import com.it.springcloud.common.page.Paging;

public class ResponseBodyPage<T> extends RespBody {

    public ResponseBodyPage() {
    }

    private Paging<T> paging;

    public Paging<T> getPaging() {
        return paging;
    }

    public void setPaging(Paging<T> paging) {
        this.paging = paging;
    }
}
