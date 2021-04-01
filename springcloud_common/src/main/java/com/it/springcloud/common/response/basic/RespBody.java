package com.it.springcloud.common.response.basic;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
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
