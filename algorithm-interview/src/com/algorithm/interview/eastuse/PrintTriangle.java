package com.algorithm.interview.eastuse;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 易思优外派国家电网公司面试题：
 * 打印三角形
 * @Date 2019/11/19 9:48
 * @Version 1.0
 */
public class PrintTriangle {

    /**
     * 打印三角形
     * 1,3,5,7,9
     * 1,2,3,4,5
     * An=n*2-1
     * @param n 行数
     */
    private static void print(int n) {
        // 控制行数
        for (int i = 1; i <= n; i++) {
            // 控制每一行的空格数
            for (int j = 1; j <= n - i; j++) {
                //行数的空格是：行数-行号
                System.out.print(" ");
            }
            // 控制每一行的*数
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行数：");
        int n = scanner.nextInt();
        print(n);
    }
}
