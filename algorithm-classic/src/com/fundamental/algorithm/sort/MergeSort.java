package com.fundamental.algorithm.sort;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：归并（合并）排序
 * @Date 2018/8/23 10:45
 * @Version 1.0
 */
public class MergeSort {

    /**
     * 数组长度
     */
    private static final int LENGTH = 10;

    /**
     * 归并过程，即完成一遍合并的方法
     * @param array
     * @param temp
     * @param n
     * @param len
     */
    private static void mergeOne(int[] array, int[] temp, int n, int len) {

    }

    /**
     * 归并（合并）排序
     * @param array
     * @param n
     */
    private static void mergeSort(int[] array, int n) {

    }

    public static void main(String[] args) {
        System.out.println("归并排序开始：");

        int[] array = new int[LENGTH];

        // 初始化数组
        for (int i = 0; i < LENGTH; i++) {
            array[i] = (int) (100 + Math.random() * (100 + 1));
        }

        System.out.println("排序前的数组为：" + Arrays.toString(array));

        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }
}
