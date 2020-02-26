package com.zjhz.gateway.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <b>功能名：</b>ProductServiceFeign<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2019 ZJHZ  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019/5/7 zhangzhonghao
 */
@FeignClient(value = "authentication-service", fallback = HystrixClientFallbackFactory.class)
public interface AuhtenticationServiceFeign {
    /**
     * <b>方法名：</b>认证调用<br>
     * <b>说明：</b> <br>
     * <b>@param </b>[object]<br>
     * <b>@return：</b>java.lang.String<br>
     * <b>修改履历：</b>
     *
     * @author 2019/5/7   zhangzhonghao
     */
    @PostMapping(value = "/auth/auth")
    boolean getAccountByDharmaByName(@RequestBody String token);
}
