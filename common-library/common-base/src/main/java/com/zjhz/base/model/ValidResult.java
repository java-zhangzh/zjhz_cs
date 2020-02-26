package com.zjhz.base.model;
import com.zjhz.base.enums.ProcuctCodeEnum;
import com.zjhz.base.exception.BusinessException;
import org.slf4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Created by VPEEN on 2019/5/7.
 */
public class ValidResult {

    public static HttpResult handleBindingResult(ProcuctCodeEnum product, BindingResult bindingResult, Logger logger) {
        bindingResult.getAllErrors().stream().forEach(
                error -> {
                    FieldError fieldError = (FieldError) error;
                    logger.error("错误字段：{} -> 错误信息：{}", fieldError.getField(), fieldError.getDefaultMessage());
                }
        );
        BusinessException exception = new BusinessException(product, 0, bindingResult.getFieldError().getDefaultMessage());
        HttpResult result = new HttpResult();
        result.fromException(exception);
        return result;
    }
}
