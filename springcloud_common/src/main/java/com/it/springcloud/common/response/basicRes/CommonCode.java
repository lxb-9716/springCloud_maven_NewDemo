package com.it.springcloud.common.response.basicRes;

import com.it.springcloud.common.response.ResultCode;

public enum CommonCode implements ResultCode {
    SUCCESS("000000", "操作成功！"),
    NOT_FOUND("111111", "调用接口成功，但是没有查询到数据!"),
    FAIL("111111", "调用接口失败！");
    //操作代码
    String code;
    //提示信息
    String message;

    private CommonCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
