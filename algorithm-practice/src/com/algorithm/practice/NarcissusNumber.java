package com.algorithm.practice;

/**
 * @Author 李非凡
 * @Description:
 * 三位数的所有水仙花数
 * @Date 2018/12/11 22:10
 * @Version 1.0
 */
public class NarcissusNumber {

    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int a = i/100;
            int b = i/10-10*a;
            int c = i-100*a-10*b;

            if (i==a*a*a+b*b*b+c*c*c) {
                System.out.println(i);
            }
        }
    }
}
