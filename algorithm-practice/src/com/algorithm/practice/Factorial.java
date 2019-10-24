package com.algorithm.practice;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 编写一个Java应用程序，在键盘上输入数n，计算并输出1!+2!+...+n!的结果
 * @Date 2018/12/11 21:28
 * @Version 1.0
 */
public class Factorial {
    
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long n=0;
        for (long i = 1; i <= num; i++) {
            n = n+doFactorial(i);
        }
        System.out.println(n);
    }

    /**
     * 阶乘会溢出，如果想算大的阶乘，用BigInteger或者数组做为容器进行运算
     * @param nums
     * @return nums
     */
    private static long doFactorial(long nums){
        if (nums<=0){
            System.out.println("ERROR");
            return 0;
        }else if (nums==1 || nums==2){
            return nums;
        }else {
            return nums*doFactorial(nums-1);
        }
    }
}
