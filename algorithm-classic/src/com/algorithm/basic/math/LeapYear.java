package com.algorithm.basic.math;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 判断闰年
 * @Date 2018/9/1 9:29
 * @Version 1.0
 */
public class LeapYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer year = scanner.nextInt();
        Integer result = LeapYear.leapYear(year);
        if (result == 1) {
            System.out.println("是闰年");
        }else{
            System.out.println("不是闰年");
        }
    }

    /**
     * 判断闰年的方法
     * @param year
     * @return
     */
    private static Integer leapYear(Integer year){
        if ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0)){
            return 1;
        }else {
            return 0;
        }
    }
}
