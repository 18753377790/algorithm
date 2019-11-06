package com.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：插入排序->（直接）插入排序
 * @Date 2018/8/22 23:27
 * @Version 1.0
 */
public class InsertionSort {

    /**
     * 插入排序
     * @param array 待排序的数组
     */
    private static void insertionSort(int[] array){
        int j,t;
        for (int i = 0; i < array.length; i++) {
            t = array[i];
            j = i - 1;
            while (j >= 0 && t < array[j]){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = t;
            System.out.println("第" + i + "步排序结果：" + Arrays.toString(array) + "\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("插入排序开始：");
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("排序前的数组：" + Arrays.toString(array) + "\n");

        insertionSort(array);

        System.out.println("排序后的数组：" + Arrays.toString(array));
    }
}
