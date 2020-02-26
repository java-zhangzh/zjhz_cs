package com.zjhz.gateway.feign;
import org.springframework.stereotype.Component;

/**
 * <b>功能名：</b>ProductServiceFeign<br>
 * <b>说明：</b>调用失败回调类<br>
 * <b>著作权：</b> Copyright (C) 2019 ZJHZ  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019/5/7   zhangzhonghao
 */
@Component
public class HystrixClientFallbackFactory implements AuhtenticationServiceFeign {
    @Override
    public boolean getAccountByDharmaByName(String token) {
        return false;
    }
}
