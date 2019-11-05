package com.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：希尔排序
 * @Date 2018/8/23 19:44
 * @Version 1.0
 */
public class ShellSort {
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("希尔排序开始：");
        scanner = new Scanner(System.in);
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("排序前的数组为："+Arrays.toString(array));

        shellSort(array);

        System.out.println("排序后的数组为："+Arrays.toString(array));
    }

    private static void shellSort(Integer[] array){
        
    }
}
