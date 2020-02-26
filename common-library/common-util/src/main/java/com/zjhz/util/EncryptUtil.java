package com.zjhz.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by VPEEN on 2018/10/5.
 */
public class EncryptUtil {
    private static String algorithmName = "MD5"; // 加密方式
    private static int hashIterations = 1000; // 加密次数

    public static JSONObject EncryptUser(String pwd) {
        // 随机盐对象
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        // 根据用户名以及随机生成的盐来拼接成密码盐
        String salt =secureRandomNumberGenerator.nextBytes().toHex();
        // 获取加密后的密码
        String passWord = new SimpleHash(algorithmName, pwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
        JSONObject data = new JSONObject();
        //设置密码盐
        data.put("salt",salt);
        //设置加密过后的密码
        data.put("passWord",passWord);
        return data;
    }


}
