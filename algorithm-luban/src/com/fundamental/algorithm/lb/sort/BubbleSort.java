package com.fundamental.algorithm.lb.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 冒泡排序
 * @Date 2019/5/19 14:13
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        /*
        4 2 5 1
        4
        4 2 => 2 4
        2 4 5
        2 4 5 1 => 1 2 4 5
         */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        // Map.size()和list.size()会花费时间
        for (int i = 0, len = data.length; i < len; i++) {
            // len需要减1，否则会数组下标越界
            for (int j = 0; j < len - 1 - i; j++) {
                if (data[j] > data[j + 1]){
                    // 交换，不让你引入第三个变量交换a b的值
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println(Arrays.toString(data));
    }
}
