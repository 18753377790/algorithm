package com.algorithm.classical_algorithm;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 汉诺塔
 * @Date 2019/11/7 11:14
 * @Version 1.0
 */
public class TowerOfHanoi {

    /**
     *
     */
    private static long count;

    /**
     * 汉诺塔移动圆盘
     * 1,1 2^1 - 1
     * 2,3 2^2 - 1
     * 3,7 2^3 - 1
     * 4,15
     * 5,31
     * f(n)=2^n - 1
     * @param n 盘子的个数
     * @param a 源座
     * @param b 辅助座
     * @param c 目的座
     */
    private static void towerOfHanoi(int n, char a, char b, char c) {
        if (n == 1)
            System.out.printf("");
        else {
            System.out.printf("");
        }
    }

    public static void main(String[] args) {
        count = 0;
        System.out.println("");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        towerOfHanoi(n,'A', 'B', 'C');

        System.out.printf("");
    }
}
