package com.algorithm.practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2019/5/6 22:38
 * @Version 1.0
 */
public class CalendarExample {

    /**
     * 日期比较的方法
     * @param date1
     * @param date2
     * @return
     */
    private long compareDate(String date1, String date2){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        long day = 0;
        try {
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(date2);
            long time1 = d1.getTime();
            long time2 = d2.getTime();
            day = (time1 - time2) / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
           e.printStackTrace();
        }

        if (day == 0){
            return day;
        }else {
            return day / 30;
        }
    }

    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();//创建一个日历对象。
        int year = calendar1.get(Calendar.YEAR);
        int month = calendar1.get(Calendar.MONTH) + 1;
        int day = calendar1.get(Calendar.DAY_OF_MONTH);
        int week = calendar1.get(Calendar.DAY_OF_WEEK) - 1;//从星期日开始
        int hour = calendar1.get(Calendar.HOUR_OF_DAY);
        int minute = calendar1.get(Calendar.MINUTE);
        int second = calendar1.get(Calendar.SECOND);
        System.out.println("现在的时间是：");
        System.out.println("" + year + "年" + month + "月" + day + "日 " + "星期" + week);
        System.out.println("" + hour + "时" + minute + "分" + second + "秒");
        calendar1.set(1949, 9, 1);//将日历翻到1949年10月1日,注意9表示十月。
        long time1949 = calendar1.getTimeInMillis();
        calendar1.set(2009, 9, 1);//将日历翻到2009年10月1日。9表示十月。
        long time2009 = calendar1.getTimeInMillis();
        long dayDiff = (time2009 - time1949) / (1000 * 60 * 60 * 24);
        System.out.println("2009年10月1日和1949年10月1日相隔" + dayDiff + "天");
    }

}