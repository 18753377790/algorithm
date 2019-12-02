package com.algorithm.interview.taikang;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 中软国际外派泰康人寿面试题：
 * 从一个有序数组里找到两个数字的和等于一个目标数字，打印出来这两个数字，要求算法和复杂度为O(n)，怎么解决？
 * @Date 2019/11/18 22:26
 * @Version 1.0
 */
public class SumToANumInArray {

    /**
     *
     * @param array
     * @param num
     */
    private static void printSumToANum(int[] array, int num) {

        for (int i = 0; i < array.length; i++) {

        }
    }

    public static void main(String[] args) {
        // 构造一个1~100的随机有序数组
        int[] array = new Random().ints(100, 1, 100).sorted().toArray();
        System.out.println(Arrays.toString(array));
        int num = new Scanner(System.in).nextInt();
        printSumToANum(array, num);
    }
}
