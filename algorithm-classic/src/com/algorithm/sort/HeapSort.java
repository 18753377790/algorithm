package com.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：选择排序->堆排序
 * @Date 2018/8/23 19:44
 * @Version 1.0
 */
public class HeapSort {

    /**
     * 数组长度
     */
    private static final int LENGTH = 10;

    /**
     * 堆排序
     * @param array 待排序的数组
     * @param n 待排序的数组长度
     */
    private static void heapSort(int[] array, int n){

    }

    public static void main(String[] args) {
        System.out.println("堆排序开始：");
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("排序前的数组为：" + Arrays.toString(array));

        heapSort(array,array.length);

        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }
}
