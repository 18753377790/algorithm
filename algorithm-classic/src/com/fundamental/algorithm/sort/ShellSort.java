package com.fundamental.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：插入排序->希尔排序
 * @Date 2018/8/23 19:44
 * @Version 1.0
 */
public class ShellSort {

    /**
     * 希尔排序
     * @param array 待排序的数组
     */
    private static void shellSort(int[] array){


        for (int r = array.length / 2; r >= 1; r /= 2){
            for (int i = r; i < array.length; i++) {

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("希尔排序开始：");
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("排序前的数组为：" + Arrays.toString(array)  + "\n");

        shellSort(array);

        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }
}
