package com.fundamental.algorithm.lb.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 希尔排序
 * @Date 2019/5/19 21:16
 * @Version 1.0
 */
public class ShellSort {

    public static void main(String[] args) {
        /*
        4 1 2 3 5
        第一步
        step = len/2 => 5/2 = 2;
        步长用于分组
        一组 4 2 分出来的还是进行一个插入排序 2 4
        二组 1 3 =>1 3
        三组 5 => 5
        2 4 1 3 5
        第二步
        step = step/2 => 2/2 => 1
         */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] data = new int[n + 1];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        // 步长
        int step = n;
        while (step >= 1){
            // 步长除以二是性能最高的
            step = step / 2;
            for (int i = step; i < n; i++) {
                for (int j = i; j - step >= 0; j -= step) {
                    if (data[j] < data[j - step]){
                        // 交换
                        int temp = data[j];
                        data[j] = data[j - step];
                        data[j - step] = temp;
                    }else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println(Arrays.toString(data));
    }
}
