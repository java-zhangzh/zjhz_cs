package com.zjhz.authentication.util;
import io.netty.util.internal.MathUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.Random;

/**
 * Created by zhangzhonghao on 2019/11/25.
 */
public class EncryptUtil {
    private static String algorithmName = "MD5"; // 加密方式
    private static int hashIterations = 1000; // 加密次数

//    public static HeadmasterInfo EncryptUser(HeadmasterInfo user) {
//        // 随机盐对象
//        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
//        // 根据用户名以及随机生成的盐来拼接成密码盐
//        String salt =secureRandomNumberGenerator.nextBytes().toHex();
//        // 获取加密后的密码
//        String passWord = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(salt), hashIterations).toHex();
//        //设置密码盐
//        user.setSalt(salt);
//        //设置加密过后的密码
//        user.setPassword(passWord);
//        return user;
//    }

    public static void main(String[] args){

       String password= EncryptPassword("123456","123456");
        System.out.println(password);
    }

    public static String EncryptPassword(String oriPassword,String salt){
        return  new SimpleHash(algorithmName, oriPassword, ByteSource.Util.bytes(salt), hashIterations).toHex();
    }
}
