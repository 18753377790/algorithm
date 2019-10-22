package com.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 排序算法：冒泡排序
 * @Date 2018/8/22 22:12
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("冒泡排序开始：");
        Scanner scanner = new Scanner(System.in);
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("排序前的数组为："+Arrays.toString(array)+"\n");

        bubbleSort(array);

        System.out.println("排序后的数组为："+Arrays.toString(array));
    }

    /**
     *
     * @param array
     */
    private static void bubbleSort(Integer[] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j]>array[j+1]){
                    Integer temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            System.out.println("第"+i+"步排序结果："+Arrays.toString(array)+"\n");
        }
    }
}
