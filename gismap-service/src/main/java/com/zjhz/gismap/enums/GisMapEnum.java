package com.zjhz.gismap.enums;

/**
 * Created by VPEEN on 2019/5/8.
 */
public enum GisMapEnum {

    AccountNotExisted(10,"账户不存在");


    private Integer code;
    private  String msg;

    GisMapEnum(Integer code, String msg) {
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

