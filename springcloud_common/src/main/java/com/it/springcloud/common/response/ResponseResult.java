package com.it.springcloud.common.response;

import com.it.springcloud.common.response.basicRes.CommonCode;

public class ResponseResult {
    //操作代码 给出默认值
    private String code = CommonCode.CODE;
    //提示信息，给出默认值
    private String message = CommonCode.MESSAGE;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseResult(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ResponseResult() {

    }
}
