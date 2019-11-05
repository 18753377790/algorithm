package com.algorithm.basic.algorithm.recursive;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 递推算法：斐波那契数列：兔子产仔问题
 * @Date 2018/8/20 21:39
 * @Version 1.0
 */
public class Fibonacci {

    /**
     * 递推算法
     * @param n 时间
     * @return 兔子对数
     */
    private static int fibonacci(int n){
        int t1, t2;
        if (n <= 0){
            System.out.println("ERROR");
            return 0;
        } else if (n == 1 || n == 2){
            return 1;
        }else {
            t1 = fibonacci(n - 1);
            t2 = fibonacci(n - 2);
            return t1 + t2;
        }
    }

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("请先输入时间：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = fibonacci(n);
        System.out.println(num);
    }
}
