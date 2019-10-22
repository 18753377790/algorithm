package com.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：选择排序
 * @Date 2018/8/22 23:27
 * @Version 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        System.out.println("选择排序开始：");
        Scanner scanner = new Scanner(System.in);
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("排序前的数组："+Arrays.toString(array)+"\n");

        selectionSort(array);

        System.out.println("排序后的数组："+Arrays.toString(array));
    }

    public static void selectionSort(Integer[] array){
        Integer index;
        for (int i = 0; i < array.length-1; i++) {
            index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j]<array[index]){
                    index = j;
                }
            }
            //
            if (index!=i){
                Integer temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
            System.out.println("第"+i+"步排序结果："+Arrays.toString(array)+"\n");
        }
    }
}
