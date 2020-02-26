package com.zjhz.util;

import com.zjhz.base.model.UserInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * <b>功能名：</b>Token<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2018 WULUXIXING  CORPORATION<br>
 * <b>修改履历：
 *
 * @aut hor 2019/5/13  zhangzhonghao
 */

public class UserInfoUtil {
    /**
    * <b>方法名：</b>获取用户信息<br>
    * <b>说明：</b> <br>
    * <b>@param </b>[redisCacheTemplate]<br>
    * <b>@return：</b>com.wuluxixing.deerfarmsevenagesservice.dto.DeerfarmUserDTO<br>
    * <b>修改履历：</b>
    *
    * @author 2019/5/13   zhangzhonghao
    */
    public static UserInfo UserInfoDTO(RedisTemplate redisCacheTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");
        Set<String> strings = redisCacheTemplate.keys(token + "*");
        UserInfo userValidateCodeInfo = null;
        if (strings.size() != 0) {
            String key = "";
            if (strings.size() > 0) {
                for (String str : strings) {
                    key = str;
                }
                userValidateCodeInfo =(UserInfo)redisCacheTemplate.opsForValue().get(key);
            }
        }
        return userValidateCodeInfo;
    }



    public static Object UserInfoObjectDTO(RedisTemplate redisCacheTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");
        Set<String> strings = redisCacheTemplate.keys(token + "*");
        Object userValidateCodeInfo = null;
        if (strings.size() != 0) {
            String key = "";
            if (strings.size() > 0) {
                for (String str : strings) {
                    key = str;
                }
                userValidateCodeInfo =redisCacheTemplate.opsForValue().get(key);
            }
        }
        return userValidateCodeInfo;
    }
}