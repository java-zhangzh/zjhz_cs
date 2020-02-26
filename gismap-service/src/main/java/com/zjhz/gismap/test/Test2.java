package com.zjhz.gismap.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 12947 on 2019/6/22.
 */
public class Test2 {
    /**
           * 按月份拆分
           *
           * @param startTime 开始时间
           * @param endTime 结束时间
           * @param intervalDay 指定日
           * @return
           * @author Shi Zezhu
           * @date 2017年8月2日 下午3:56:05
           */
     public static List<Timestamp> splitMonth(Timestamp startTime, Timestamp endTime, Integer intervalDay) {
     List<Timestamp> list = new ArrayList<>();
       if (startTime == null || endTime == null) {
         return list;
       }
       Calendar startCalendar = Calendar.getInstance();
       startCalendar.setTime(startTime);
       Calendar endCalendar = Calendar.getInstance();
       endCalendar.setTime(endTime);
       Calendar nextCalendar = Calendar.getInstance();
       nextCalendar.set(startCalendar.get(Calendar.YEAR), startCalendar.get(Calendar.MONTH), startCalendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
       nextCalendar.set(Calendar.MILLISECOND, 0);
       list.add(startTime);
       while (intervalDay != null) {
         if (intervalDay < 1) {
           intervalDay = 1;
         }
         if (intervalDay == 1) {
           nextCalendar.add(Calendar.MONTH, 1);
         }
         nextCalendar.set(Calendar.DAY_OF_MONTH, nextCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) > intervalDay ? intervalDay - 1   : nextCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
         if (nextCalendar.compareTo(endCalendar) != -1) {
           break;
         }
         if (startCalendar.before(nextCalendar)) {
           startCalendar.setTime(nextCalendar.getTime());
           list.add(new Timestamp(startCalendar.getTimeInMillis()));
           startCalendar.add(Calendar.SECOND, 1);
           list.add(new Timestamp(startCalendar.getTimeInMillis()));
         }
         nextCalendar.add(Calendar.MONTH, 1);
       }
       list.add(endTime);
       return list;
     }


  /**
         * 按月份拆分
         *
         * @param startTime 开始时间
         * @param endTime 结束时间
         * @return
         * @author Shi Zezhu
         * @date 2017年8月2日 下午3:56:05
         */
 public static List<Timestamp> splitMonth(Timestamp startTime, Timestamp endTime) {
  return splitMonth(startTime, endTime, null);
 }


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

   public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp startTime = new Timestamp(sdf.parse("2016-12-30").getTime());
        Timestamp endTime = new Timestamp(sdf.parse("2017-03-18").getTime());

       List<String> list= getMonthBetweenDates("2016-12-30","2017-03-18");


        for (String t : list) {
           System.out.println(t);
        }
     }





}




