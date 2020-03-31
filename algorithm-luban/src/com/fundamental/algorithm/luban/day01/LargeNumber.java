package com.fundamental.algorithm.luban.day01;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 大数字运算
 * 对于大数字运算，int型，long型和BigInteger类容量都不足，所以应当用数组存储大数据
 * Java一般用线性结构如数组来充当存储数字的容器
 * C++一般用字符串，因为在C++中字符串是可变的。
 * @Date 2019/3/14 19:28
 * @Version 1.0
 */
public class LargeNumber {
    /**
     * @SuppressWarnings("")注解消除黄线警告
     * all代表消除所有警告
     * @param args
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {

        //512*34
        int[] array = new int[8];
        array[array.length-1] = 2;//最后一位放个位，向前依次类推
        array[array.length-2] = 1;
        array[array.length-3] = 5;
        int num = 34;

        // 1.计算每一位的结果
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*num;
        }
        // 2.对每一位进行进位和留位（i不能等于0，防止数组下标越界）
        for (int i = array.length-1; i > 0; i--) {
            // 先进后留
            array[i-1] += array[i]/10;
            array[i] %= 10;
        }
        //3.打印结果
        System.out.println(Arrays.toString(array));
    }
}
