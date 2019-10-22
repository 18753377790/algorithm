package com.algorithm.practice;

import java.util.*;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2019/5/6 22:38
 * @Version 1.0
 */
public class CalendarExample {
    public static void main(String args[]) {
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