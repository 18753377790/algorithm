package com.algorithm.offer.recursion_and_loop;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @Date 2019/11/1 10:38
 * @Version 1.0
 */
public class FibonacciSequence {

    /**
     * 斐波那契数列
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
     * 0, 1, 2, 3, 4, 5, 6, 7,  8,  9 , 10, 11
     * F(n) = F(n-1)+F(n-2)
     * @param n 斐波那契数列的第n项
     * @return 斐波那契数列的第n项的值
     */
    private int Fibonacci(int n) {
        if (n < 0 || n > 39)
            return -1;
        if (n <= 1)
            return n;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        System.out.println(fibonacciSequence.Fibonacci(num));
    }
}
