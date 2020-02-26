package com.zjhz.util;

import com.github.pagehelper.util.StringUtil;

import java.math.BigDecimal;

public class DistanceUtil {
 
	private static double  DEF_PI =Math.PI;// 3.14159265359
    private static double  DEF_2PI =2 *Math.PI;// 6.28318530712
	private static double  DEF_PI180 =Math.PI/ 180.0;// 0.01745329252
	private static double  DEF_R =6370996.81;// 地球的半径
	
	/**
	 * 通过两点的经纬度计算两点直线距离
	 * @param lng1Str  终端经度
	 * @param lat1Str  终端纬度
	 * @param lng2Str  商家经度
	 * @param lat2Str  商家纬度
	 * @return 返回的值四舍五入并保留两位小数,单位米
	 */
	public static Double getTwopointsDistance(String lng1Str,String lat1Str, String lng2Str,String lat2Str) {
		if ((StringUtil.isEmpty(lat1Str)) || (StringUtil.isEmpty(lng1Str))
				|| (StringUtil.isEmpty(lat2Str))
				|| (StringUtil.isEmpty(lng2Str))){return null;}
		
		Double lon1 = Double.parseDouble(lng1Str.trim());
        Double lat1 = Double.parseDouble(lat1Str.trim());
        Double lon2 = Double.parseDouble(lng2Str.trim());
        Double lat2 = Double.parseDouble(lat2Str.trim());
        
        // 角度转换为弧度
        double ew1 =  lon1 * DEF_PI180;
        double ns1 =  lat1 * DEF_PI180;
        double ew2 =  lon2 * DEF_PI180;
        double ns2 =  lat2 * DEF_PI180;
        
        // 求大圆劣弧与球心所夹的角(弧度)
        double distance = Math.sin(ns1) * Math.sin(ns2)+ Math.cos(ns1)* Math.cos(ns2)* Math.cos(ew1- ew2);
        // 调整到[-1..1]范围内，避免溢出
        if(distance >1.0) distance = 1.0;
        else if(distance <-1.0) distance = -1.0;
        distance = DEF_R *Math.acos(distance);
        
        //格式化返回值
        BigDecimal bd = new BigDecimal(distance);
        return distance = bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 判断两点距离是否在比较距离之内
	 * @param distance 需要比较的距离
	 * @param lng1Str  终端经度
	 * @param lat1Str  终端经度
	 * @param lng2Str  商家经度
	 * @param lat2Str  商家纬度
	 * @return
	 */
	public static boolean isWithin(Integer distance,String lng1Str,String lat1Str, String lng2Str,String lat2Str){
		if (distance == null || distance <= 0) return false;
		if ((StringUtil.isEmpty(lat1Str)) || (StringUtil.isEmpty(lng1Str))
				|| (StringUtil.isEmpty(lat2Str))
				|| (StringUtil.isEmpty(lng2Str))){return false;}
		Double calDistance =  getTwopointsDistance(lng1Str,lat1Str,lng2Str,lat2Str);
		if(calDistance !=null){
			boolean result = distance >= (calDistance.intValue()) ? true : false;
			return result;
		}
		return false;
	}
	

}
