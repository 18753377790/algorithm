package com.algorithm.luban.day01;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 大数字运算计算阶乘
 * 对于大数字阶乘运算，int型，long型和BigInteger类容量都不足，所以利用数组存储大数字阶乘运算的结果
 * @Date 2019/4/6 22:57
 * @Version 1.0
 */
public class LargeNumberFactorial {

    public static void main(String[] args) {
//        //阶乘
//        int num = 1;
//        int n = 50;
//
//        for (int i = 0; i <= n ; i++) {
//            num *= i;
//        }
//        System.out.println(num);
        int[] ints = new int[100];
        ints[ints.length - 1] = 1;//乘数
        int n = 50;

        for (int i = 1; i <= n ; i++) {
            operation(ints, i);//这里可以使用运算符重载
        }

        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

    /**
     * 利用数组存储数据的大数字运算方法
     * @param ints
     * @param num
     * @return
     */
    @SuppressWarnings("all")
    public static int[] operation(int[] ints, int num){
        // 1.计算每一位的结果
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ints[i]*num;
        }
        // 2.对每一位进行进位和留位（i不能等于0，防止数组下标越界）
        for (int i = ints.length-1; i > 0; i--) {
            //先进后留
            ints[i-1] += ints[i]/10;
            ints[i] %= 10;
        }
        return ints;
    }
}
