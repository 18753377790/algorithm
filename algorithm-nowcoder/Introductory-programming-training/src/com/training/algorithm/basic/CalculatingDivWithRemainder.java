package com.training.algorithm.basic;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 计算带余除法
 * 题目描述
 * 给定两个整数a和b (－10,000 < a,b < 10,000)，计算a除以b的整数商和余数。
 *
 * 输入描述:
 * 一行，包括两个整数a和b，依次为被除数和除数（不为零），中间用空格隔开。
 * 输出描述:
 * 一行，包含两个整数，依次为整数商和余数，中间用一个空格隔开。
 *
 * 示例1
 * 输入
 * 15 2
 * 输出
 * 7 1
 * @Date 2020/3/17 22:44
 * @Version 1.0
 */
public class CalculatingDivWithRemainder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String[] strings = str.split(" ");

        int num1 = Integer.parseInt(strings[0]);
        int num2 = Integer.parseInt(strings[1]);

        int div = num1 / num2;
        int remainder = num1 % num2;

        System.out.println(div + " " + remainder);
    }
}
