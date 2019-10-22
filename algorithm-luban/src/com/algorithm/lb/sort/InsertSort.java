package com.algorithm.lb.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 插入排序
 * @Date 2019/5/19 14:24
 * @Version 1.0
 */
public class InsertSort {

    public static void main(String[] args) {
        /*
        4 2 3 1
        第一步：4
        第二步：2 4
        第三步：2 3 4
        第四步：1 2 3 4
         */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] data = new int[n+1];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        // 每次加的数进来
        for (int i = 1; i < n; i++) {
            // 这个j表示的是已经排好序的序列
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]){
                    // 交换，不让你引入第三个变量交换a b的值
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }else {
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println(Arrays.toString(data));
    }
}
/*
    a = 2,b = 3
    a = a + b a = 5
    b = a - b b = 2
    a = a - b a = 3
 */