package com.algorithm.interview_question;

import java.util.Date;

/**
 * @Author 李非凡
 * @Description:
 * 获得任意时间的下一天时间
 * @Date 2019/11/18 11:23
 * @Version 1.0
 */
public class NextDay {

    /**
     * 获得下一天
     * @param day 今天的日期
     * @return 明天的日期
     */
    private static Date getNextDate(Date day) {
        long addTime = 1;
//        addTime *= 1;
        addTime *= 24;
        addTime *= 60;
        addTime *= 60;
        addTime *= 1000;
        return new Date(day.getTime() + addTime);
    }

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(getNextDate(now));
    }
}
