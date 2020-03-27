package com.algorithm.practice;

/**
 * @Author 李非凡
 * @Description:
 * 找出一个正负数都有的数组中最大的子数组之和。
 *
 * 输入一个整形数组，数组里有正数也有负数。
 *
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值。
 *
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
 * 因此输出为该子数组的和18。
 * @Date 2019/4/19 8:11
 * @Version 1.0
 */
public class MaxSubArray {

    public static void main(String[] args) {

    }

    /**
     *
     */
    private static void findMaxSubArraySum() {
        //sum为子数组的和
        int sum = 0;
        //max为子数组的最大和
        int max = 0;
        //最大子数组的起始位置
        int startPos = 0;
        //最大子数组的结束位置
        int endPos = 0;
        int[] array = {-1, 2, -3, 12, -5, -1, 9, -2};

        for (int i = 0; i < array.length; i++) {
            // 求和
            sum += array[i];
            // 如果当前求得总和为负数的话，就将其清零，并且开始位置从下一个位置开始
            if (sum < 0) {
                sum = 0;
                startPos = i + 1;
            }
            // 如果求得总和大于之前的最大值的话，就将sum赋值给max，同时记录最后的位置
            if (sum > max) {
                max = sum;
                endPos = i + 1;
            }
        }
        System.out.println("Max:" + max);
        System.out.println("startPos:" + startPos + ",endPos:" + (endPos - 1));
    }
}