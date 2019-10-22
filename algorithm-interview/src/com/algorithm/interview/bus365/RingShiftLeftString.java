package com.algorithm.interview.bus365;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 盛威时代面试题
 * 编写一个方法，作用是把一个String字符串循环左移n个
 * @Date 2019/7/31 21:16
 * @Version 1.0
 */
public class RingShiftLeftString {

    /**
     * 字符串左移
     * @param oldStr
     * @param position
     * @return
     */
    private static String ringShiftLeftString(String oldStr, int position){
        // 左移的字符串
        String str1 = oldStr.substring(oldStr.length() - position, oldStr.length());
        // 原字符串去掉左移字符串之后的字符串
        String str2 = oldStr.substring(0, oldStr.length() - position);
        return str1 + str2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String oldStr = scanner.nextLine();
        System.out.println("原字符串为：" + oldStr);
        int position = scanner.nextInt();
        System.out.println("移动的位数：" + position);
        String newStr = ringShiftLeftString(oldStr, position);
        System.out.println("新字符串为：" + newStr);
    }
}
