package com.zjhz.base.enums;

/**
 * Created by VPEEN on 2019/5/7.
 */
public enum ProcuctCodeEnum {
    GisMap(10,"前端GisMap层"),
    Auth(20,"管理平台");

    private Integer code;
    private String name;

    ProcuctCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
