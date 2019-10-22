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
     * @param n
     * @return
     */
    private static Integer fibonacci(Integer n){
        Integer t1,t2;
        if (n <= 0){
            System.out.println("ERROR");
            return null;
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
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer num = fibonacci(n);
        System.out.println(num);
    }
}
