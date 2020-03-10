package com.algorithm.huawei;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 数字颠倒
 * 描述：
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * 输入描述：输入一个int整数
 * 输出描述：将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入：1516000
 * 输出：0006151
 * @Date 2020/3/6 15:26
 * @Version 1.0
 */
public class NumberReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 47697;
        System.out.println(reverse(num));
    }

    /**
     *
     * @param num
     * @return
     */
    private static String numberReverse(int num) {

        return null;
    }

    /**
     *
     * @param num
     * @return
     */
    private static String reverse(int num) {
        return new StringBuilder().append(num).reverse().toString();
    }


}
