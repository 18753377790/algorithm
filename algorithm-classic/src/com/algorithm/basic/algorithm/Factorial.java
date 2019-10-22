package com.algorithm.basic.algorithm;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 递归算法：n!(n的阶乘)问题
 * @Date 2018/8/20 23:41
 * @Version 1.0
 */
public class Factorial {

    /**
     * 递归算法
     * @param n
     * @return
     */
    private static Integer factorial(Integer n){
        if (n < 1){
            System.out.println("ERROR");
            return 0;
        }else if (n == 1 || n == 2){
            return n;
        }else {
            return n*factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入要求阶乘的一个整数：");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        System.out.println(n + "的阶乘结果为" + factorial(n));
    }
}
