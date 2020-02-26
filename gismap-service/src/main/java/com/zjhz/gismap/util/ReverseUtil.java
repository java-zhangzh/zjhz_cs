package com.zjhz.gismap.util;

/**
 * <b>功能名：</b>NumberUtil<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2019 ZJHZ  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019-06-24 zhangzhonghao
 */
public class ReverseUtil {

    public static String   reverse(String str) {
        String ret=new StringBuilder(str).reverse().toString();
        System.out.println(ret);
        return ret;

    }
    public static long  reverse(long a) {
        long rs = 0;
        while (a > 0) {
            rs *= 10;
            rs += a % 10;
            a /= 10;
        }
        System.out.println(rs);
        return rs;

    }

    public static void main(String[] args)
    {
        //long aaa=1234567890;
        //reverse(aaa);
        reverse("1234567890");
    }

}