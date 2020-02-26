package com.zjhz.util;

import com.github.pagehelper.util.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 12947 on 2019/5/30.
 */
public class DateTimeUtil {


    public static int  getCurrAMOrPM(){
        GregorianCalendar ca = new GregorianCalendar();
        return ca.get(GregorianCalendar.AM_PM);
    }

    public static Date toDate(String dateStr){
        String dateFormat = "yyyy-MM-dd";
        return toDateFormat(dateStr, dateFormat);
    }

    public static Date toDateAndMin(String dateStr){
        String dateFormat = "yyyy-MM-dd HH:mm";
        return toDateFormat(dateStr, dateFormat);
    }

    public static Date toDateAndMinAndSec(String dateStr){
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        return toDateFormat(dateStr, dateFormat);
    }

    public static Date toTime(String dateStr){
        String dateFormat = "HH:mm:dd";
        return toDateFormat(dateStr, dateFormat);
    }

    public static Date toDateFormat(String dateStr, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        if (!StringUtil.isEmpty(dateStr)){
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 根据日期查询星期
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        int week_index = getWeekIndex(date);
        return weeks[week_index];
    }

    /**
     * 根据日期查询星期Index
     * @param date
     * @return
     */
    public static int getWeekIndex(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<=0){
            week_index = 7;
        }
        return week_index;
    }

    /**
     * 获取当月所有日期
     * @param date
     * @return
     */
    public static List<Date> getAllDateOfMonth(Date date) {
        List<Date> list = new ArrayList<Date>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR, 0);
        int month = cal.get(Calendar.MONTH);
        while(cal.get(Calendar.MONTH) == month){
            list.add(cal.getTime());
            cal.add(Calendar.DATE, 1);
        }
        return list;
    }

    /**
     * 获取两天之间的所有日期
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetweenDates(String minDate, String maxDate) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<String> result = new ArrayList<String>();
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 获取当月第一天
     * @param dateStr
     * @return
     */
    public static Date getMonthFirstDay(String dateStr){
        Calendar c = Calendar.getInstance();
        c.setTime(DateTimeUtil.toDate(dateStr));
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH,1);
        return c.getTime();
    }

    /**
     * 获取当月最后一天
     * @param dateStr
     * @return
     */
    public static Date getMonthLastDay(String dateStr){
        //获取当前月最后一天
        Calendar c = Calendar.getInstance();
        c.setTime(toDate(dateStr));
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * 计算两个日期相差年数
     * @param startDate
     * @param endDate
     * @return
     */
    public static int yearDateDiff(String startDate,String endDate){
        //获取日历实例
        Calendar calBegin = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();
        //字符串按照指定格式转化为日期
        calBegin.setTime(toDate(startDate));
        calEnd.setTime(toDate(endDate));
        return calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);
    }


}
