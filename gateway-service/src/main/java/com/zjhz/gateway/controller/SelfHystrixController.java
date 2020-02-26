package com.zjhz.gateway.controller;
import com.zjhz.base.model.HttpResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>功能名：</b>SelfHystrixController<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2019 ZJHZ  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019-06-11 zhangzhonghao
 */
@RestController
public class SelfHystrixController {
    @RequestMapping("/defaultfallback")
    public HttpResult defaultfallback(){
        HttpResult httpResult =new HttpResult();
        httpResult.setErrorMessage("找不到服务器");
        httpResult.setErrorCode(-1);
        return httpResult;
    }
}
