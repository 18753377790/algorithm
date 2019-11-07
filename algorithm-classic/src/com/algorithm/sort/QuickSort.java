package com.algorithm.sort;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：交换排序->快速排序
 * @Date 2018/8/22 23:27
 * @Version 1.0
 */
public class QuickSort {

    /**
     * 数组长度
     */
    private static final int LENGTH = 10;

    /**
     * 快速排序
     * @param array 待排序的数组
     * @param left 数组起始下标
     * @param right 数组终止下标
     */
    private static void quickSort(int[] array, int left, int right){

        // 快速排序的分界值
        int pivot = array[(left + right) / 2];
        // 起始下标
        int start = left;
        // 终止下标
        int end = right;
        //
        while (start < end) {
            //
            while (array[start] < pivot)
                ++start;
            //
            while (array[end] > pivot)
                --end;
            //
            if (start <= end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        //
        if (start == end)
            start++;
        //
        if (left < end)
            quickSort(array, left, end - 1);
        //
        if (start < right)
            quickSort(array, end + 1, right);
    }

    public static void main(String[] args) {

        System.out.println("快速排序开始：");

        int[] array = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            array[i] = (int) (100 + Math.random() * (100 + 1));
        }

        System.out.println("排序前的数组为：" + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }
}
