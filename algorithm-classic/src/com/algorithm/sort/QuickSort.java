package com.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：快速排序
 * @Date 2018/8/22 23:27
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        System.out.println("快速排序开始：");
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("排序前的数组为：" + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }

    /**
     * 快速排序
     * @param array
     * @param start
     * @param end
     */
    private static void quickSort(int[] array, int start, int end){

    }
}
