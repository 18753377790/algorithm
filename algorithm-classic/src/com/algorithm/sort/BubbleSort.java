package com.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：交换排序->冒泡排序
 * @Date 2018/8/22 22:12
 * @Version 1.0
 */
public class BubbleSort {

    /**
     * 数组长度
     */
    private static final int LENGTH = 10;

    /**
     * 冒泡排序
     * @param array 待排序的数组
     */
    private static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
            System.out.println("第" + i + "步排序结果：" + Arrays.toString(array) + "\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("冒泡排序开始：");
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("排序前的数组为：" + Arrays.toString(array) + "\n");

        bubbleSort(array);

        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }
}
