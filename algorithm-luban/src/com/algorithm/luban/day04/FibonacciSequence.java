package com.algorithm.luban.day04;

/**
 * @Author 李非凡
 * @Description:
 * 斐波那契数列：1，1，2，3，5，8...
 * 循环实现：效率高，代码可读性强
 * 递归实现：效率极低，代码可读性差，能不用递归尽量不用，但是用循环能实现的用递归都能实现
 * @Date 2019/4/14 1:45
 * @Version 1.0
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        // 循环实现斐波那契数列
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;
        // 计算第六个位置的值
        int n = 6;

        for (int i = 3; i <= n; i++) {
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        System.out.println(num3);

        // 递归实现
        int num = doFactorial(6);
        System.out.println(num);
    }

    /**
     * 执行递归的方法
     * n=第几个位置，返回类型就是第n个位置的斐波那契数列的值
     * @param n
     * @return
     */
    private static int doFactorial(int n){
        if (n == 1 || n == 2){
            return 1;
        }else {
            return doFactorial(n - 1) + doFactorial(n - 2);
        }
    }
}
