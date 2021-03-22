package com.it.springcloud.common.response.basic;

import java.util.List;

public class RespBody<T> {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public RespBody() {
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
