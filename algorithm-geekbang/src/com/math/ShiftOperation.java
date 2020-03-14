package com.math;

/**
 * @Author 李非凡
 * @Description: 位运算移位操作
 * 二进制左移一位，其实就是将数字翻倍。
 *
 * Java 里定义了两种右移，逻辑右移和算术右移。逻辑右移 1 位，左边补 0 即可。
 * 二进制右移一位，就是将数字除以 2 并求整数商的操作。
 * @Date 2020/3/14 1:54
 * @Version 1.0
 */
public class ShiftOperation {


    public static void main(String[] args) {

        int num = 53;
        int m = 1;
        // 测试向左移位
        System.out.println(String.format("数字%d的二进制向左移%d位是%d", num, m, leftShift(num, m)));
        // 测试向右移位
        System.out.println(String.format("数字%d的二进制向右移%d位是%d", num, m, rightShift(num, m)));

        System.out.println();

        m = 3;
        // 测试向左移位
        System.out.println(String.format("数字%d的二进制向左移%d位是%d", num, m, leftShift(num, m)));
        // 测试向右移位
        System.out.println(String.format("数字%d的二进制向右移%d位是%d", num, m, rightShift(num, m)));
    }


    /**
     * 向左移位
     * @param num
     * @param m
     * @return
     */
    private static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * 向右移位
     * @param num
     * @param m
     * @return
     */
    private static int rightShift(int num, int m) {
        return num >>> m;
    }
}
