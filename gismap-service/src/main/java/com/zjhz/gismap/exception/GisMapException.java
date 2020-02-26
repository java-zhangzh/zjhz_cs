package com.zjhz.gismap.exception;

import com.zjhz.base.enums.ProcuctCodeEnum;
import com.zjhz.base.exception.BusinessException;
import com.zjhz.gismap.enums.GisMapEnum;

/**
 * Created by VPEEN on 2019/5/13.
 */
public class GisMapException extends BusinessException {

    public GisMapException(GisMapEnum resultEnum) {
        super(ProcuctCodeEnum.GisMap,resultEnum.getCode(),resultEnum.getMsg());
    }

}
