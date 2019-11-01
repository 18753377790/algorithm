package com.algorithm.lb.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 快速排序
 * @Date 2019/5/19 21:32
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int n = scanner.nextInt();
//        int[] data = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            data[i] = scanner.nextInt();
//        }

        int[] data = {45, 28, 80, 90, 50, 16, 100, 10};
        quickSort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));
    }

    /**
     * 45 28 80 90 50 16 100 10
     * 选基准数：一般是序列的第一个 45
     *
     * 10 28 80 90 50 16 100 45
     * 10 28 45 90 50 16 100 80
     *
     * 10 28 16 90 50 45 100 80
     * 10 28 16 45 50 90 100 80
     *
     * {10 28 16} 45 {50 90 100 80}
     *
     * 10 28 16
     * 50 90 100 80
     * @param data 待排序的数组
     * @param left 左边第一个数的位置
     * @param right 右边第一个数的位置
     */
    private static void quickSort(int[] data, int left, int right){
        // 从左边找的位置
        int start = left;
        // 从右边找的位置
        int end = right;
        // 基准数，一般是序列的第一个数，取第一个作为基准数
        int base = data[left];
        // 当start == end时，位置重叠
        while (start < end){
            // 从后面往前面找到比基准数小的数进行对换
            while (start < end && data[end] >= base){
                end--;
            }
            // 为了防止没找到，即标准数是数组中最小的数
            if (start < end){
                int temp = data[end];
                data[end] = data[start];
                data[start] = temp;
                start++;
            }
            // 从前面往后面找到比基准数大的数进行对换
            while (start < end && data[start] <= base){
                start++;
            }
            // 为了防止没找到，即标准数是数组中最大的数
            if (start < end){
                int temp = data[end];
                data[end] = data[start];
                data[start] = temp;
                end--;
            }
            System.out.println("Base=" + base);
        }
        // 以基准数分为3部分，左边的比之小，右边的比之大，我们要做的就是把这左边和右边分别进行快速排序
        if (start > left){
            quickSort(data, left, start - 1);
        }
        if (end < right){
            quickSort(data, start + 1, right);
        }
    }
}
