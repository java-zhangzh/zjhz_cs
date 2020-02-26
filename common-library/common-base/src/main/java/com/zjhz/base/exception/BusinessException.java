package com.zjhz.base.exception;
import com.zjhz.base.enums.ProcuctCodeEnum;

/**
 * Created by VPEEN on 2018/9/25.
 */
public class BusinessException extends RuntimeException {
    protected Integer code;
    public BusinessException(ProcuctCodeEnum procuctCodeEnum,Integer code, String msg) {
        super(msg);
        String strCode = procuctCodeEnum.getCode()+""+ code +"";
        this.code = Integer.parseInt(strCode);
    }

    public Integer getCode() {
        return code;
    }
}


