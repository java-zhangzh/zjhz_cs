package com.zjhz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhangzhonghao,
 * @date 2019/5/28
 * @time 14:54
 */
public class TimeUtil {

    private static final String[] CN_NUMBER_NAME = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CN_NUMBER_MODRNAME = { "一", "二", "三", "四", "五", "六", "七", "八", "九","十","十一","十二"};


    /**
     *  获取当前时间    参数是格式
     * @param param  字符参数  null  获取当前时间 默认 格式 yyyy-MM-dd HH:mm:ss
     *                 字符参数  年月日  格式为yyyy-MM-dd
     *                 字符参数  年月  格式为yyyy-MM
     *                 字符参数  时分秒   格式为 HH:mm:ss
     *                 字符传输  时分    HH:mm
     *                 字符参数  年  yyyy
     *                 字符参数  月   MM
     *                 字符参数  日   dd
     *
     * @return  格式时间 2019-05-06 12:02:02
     */
    public static  String  getTimeToString(String param){
        String   formatString="yyyy-MM-dd HH:mm:ss";
        if("年月日".equals(param))
        {
            formatString="yyyy-MM-dd";
        }
        if("年月".equals(param))
        {
            formatString="yyyy-MM";
        }
        if("时分秒".equals(param))
        {
            formatString="HH:mm:ss";
        }

        if("时分".equals(param))
        {
            formatString="HH:mm";
        }
        if("年".equals(param))
        {
            formatString="yyyy";
        }

        if("月".equals(param))
        {
            formatString="MM";
        }

        if("日".equals(param))
        {
            formatString="dd";
        }

        SimpleDateFormat df = new SimpleDateFormat(formatString);
        return  df.format(new Date());
    }

    /**
     *   时间转换。  转换成自定义格式
     * @param data  Date 类型
     * @param param  格式
     * @return
     */
    public static  String fromTimeToFormat(Date data,String param){
        if(data==null)
        {
            data=new Date();
        }
        SimpleDateFormat df = new SimpleDateFormat(param);//设置日期格式
        return  df.format(data).toString();
    }


    public  static String getCurrentCNDate(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance(); // 使用日历类
        try {
            cal.setTime(df.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String year = String.valueOf(cal.get(Calendar.YEAR)); // 得到年
        String month = String.valueOf(cal.get(Calendar.MONTH) + 1); // 得到月，因为从0开始的，所以要加1
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)); // 得到天

        StringBuilder cnDate = new StringBuilder();
        for (int i = 0; i < year.length(); i++) {
            cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(year.charAt(i)))]);
        }

        cnDate.append("年");
        cnDate.append("-");
        cnDate.append(CN_NUMBER_MODRNAME[Integer.valueOf(String.valueOf(month))-1]);
        cnDate.append("月");
        cnDate.append("-");

        if (day.length() == 2) {
            Integer value = Integer.valueOf(String.valueOf(day.charAt(0)));
            if (!value.equals(1)) {
                cnDate.append(CN_NUMBER_NAME[value]);
            }
            cnDate.append("十");
            if (!String.valueOf(day.charAt(1)).equals("0")) {
                cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(day.charAt(1)))]);
            }
        } else {
            cnDate.append(CN_NUMBER_NAME[Integer.valueOf(String.valueOf(day.charAt(0)))]);
        }

        cnDate.append("日");
        return cnDate.toString();
    }



    public static  void main (String[] age)
    {
        System.out.println( getCurrentCNDate("2019-06-05"));
    }

    public static List<String> getMonthEverySingleDayByNewDate(String yearParam, String monthParam){

        List list = new ArrayList();
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.set(Integer.parseInt(yearParam),Integer.parseInt(monthParam),0);
        int year = aCalendar.get(Calendar.YEAR);//年份
        int month = aCalendar.get(Calendar.MONTH) + 1;//月份
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String aDate=null;
            if(month<10&&i<10){
                aDate = String.valueOf(year)+"-0"+month+"-0"+i;
            }
            if(month<10&&i>=10){
                aDate = String.valueOf(year)+"-0"+month+"-"+i;
            }
            if(month>=10&&i<10){
                aDate = String.valueOf(year)+"-"+month+"-0"+i;
            }
            if(month>=10&&i>=10){
                aDate = String.valueOf(year)+"-"+month+"-"+i;
            }

            list.add(aDate);
        }
        return list;
    }
    /**
     * 时间比对
     *
     * @param data  1
     * @param current 2
     * @return 1    参数1 比参数2 大  -1 则相反
     */
    public static  int ComparingTime(Date data,Date current)
    {

        if(current ==null)
        {
            current = new Date();
        }
        try {
            if (data.getTime() > current.getTime()) {
                return 1;
            } else if (data.getTime() < current.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }




    /**
     * 得到几天前的时间
     * 
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar no = Calendar.getInstance();
        no.setTime(d);
        no.set(Calendar.DATE, no.get(Calendar.DATE) - day);
        return no.getTime();
    }

}
