package com.algorithm.practice;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 计算并输出一个整数各位数字之和
 * @Date 2018/12/11 22:11
 * @Version 1.0
 */
public class IntegerSum {
    private static Scanner scanner;
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int n = 0;
        while (num>0){
          n = n + num%10;
          num = num/10;
        }
        System.out.println(n);
    }
}
