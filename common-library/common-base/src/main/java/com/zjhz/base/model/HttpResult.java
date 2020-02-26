package com.zjhz.base.model;

import com.zjhz.base.exception.BusinessException;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by VPEEN on 2019/5/7.
 */

@Data
public class HttpResult<T> implements Serializable{
     private boolean success = false;
     private String errorMessage ;
    private int errorCode = 0;
    private T model;
    public HttpResult() {
        this.success = false;
    }

    public void fromException(Exception exp){
        if(exp instanceof BusinessException){
            setSuccess(false);
            setErrorMessage(exp.getMessage());
            setErrorCode(((BusinessException)(exp)).getCode());
          //  logger.error(exp.getMessage());
        }else{
            setSuccess(false);
            setErrorMessage("系统繁忙，请稍候重试");
            setErrorCode(-1);
         //   logger.error(exp.getMessage());
        }
    }
}
