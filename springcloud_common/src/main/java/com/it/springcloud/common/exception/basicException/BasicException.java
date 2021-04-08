package com.it.springcloud.common.exception.basicException;

public abstract class BasicException extends Exception {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BasicException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}
