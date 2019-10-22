package com.algorithm.practice;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 完全数
 * @Date 2018/12/11 22:09
 * @Version 1.0
 */
public class PerfectNumber {

    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num<=0){
            System.out.println("请输入正整数！");
            return;
        }
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num%i==0){
                sum += i;
            }
        }
        if (num == sum){
            System.out.println(num+"是完全数");
        }else{
            System.out.println(num+"不是完全数");
        }

    }
}
