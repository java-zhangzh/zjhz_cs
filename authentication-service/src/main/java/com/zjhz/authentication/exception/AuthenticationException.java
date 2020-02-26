package com.zjhz.authentication.exception;

import com.zjhz.authentication.enums.AuthenticationEnum;
import com.zjhz.base.enums.ProcuctCodeEnum;
import com.zjhz.base.exception.BusinessException;

/**
 * Created by zzh on 2019/11/21.
 */
public class AuthenticationException extends BusinessException {

    public AuthenticationException(AuthenticationEnum resultEnum) {
        super(ProcuctCodeEnum.GisMap,resultEnum.getCode(),resultEnum.getMsg());
    }

}
