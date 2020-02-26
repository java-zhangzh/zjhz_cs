package com.zjhz.authentication.enums;

/**
 * Created by zzh on 2019/11/21.
 */
public enum AuthenticationEnum {

    AccountNotExisted(10,"账户不存在");
    private Integer code;
    private  String msg;

    AuthenticationEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}

