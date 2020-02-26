package com.zjhz.authentication.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;

/**
 * <b>功能名：</b>LoginVerification<br>
 * <b>说明：</b><br>
 * <b>修改履历：
 *
 * @author 2019-11-21 zhangzh
 */
public class LoginVerification {
    /**
     * <b>方法名：</b>清除重复登入<br>
     * <b>说明：</b> <br>
     * <b>@param </b>[redisTemplate, token]<br>
     * <b>@return：</b>cvoid<br>
     * <b>修改履历：</b>
     *
     * @author 2019/11/21   zhangzh
     */public  static void getAccountByDharmaByName(RedisTemplate redisTemplate, String token) {
         System.out.println("========================redis===========redisTemplate:"+redisTemplate);
        System.out.println("========================redis===========redisTemplate:"+redisTemplate.opsForValue());
        Set<String> strings = redisTemplate.keys(token+"*");
        System.out.println("========================redis===========strings:"+strings.size());
        String key = "";
        if (strings.size() > 0) {
            for (String str : strings) {
                key = str;
                ValueOperations<String, String> vo = redisTemplate.opsForValue();
                vo.getOperations().delete(key);
            }
        }
    }
}
