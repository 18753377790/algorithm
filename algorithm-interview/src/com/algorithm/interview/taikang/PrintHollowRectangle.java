package com.algorithm.interview.taikang;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 中软国际外派泰康人寿面试题：打印一个空心矩形（n*n）
 * #####
 * #   #
 * #   #
 * #   #
 * #####
 * @Date 2019/11/18 22:42
 * @Version 1.0
 */
public class PrintHollowRectangle {

    /**
     * 打印长宽均为n的空心矩形
     * @param n 边长
     */
    private static void print(int n) {

        // 控制行
        for (int i = 1; i <= n; i++) {
            // 控制列
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n)
                    System.out.print("#");
                else if (j == 1 || j == n)
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("请输入边长：");
        print(n);
    }
}
