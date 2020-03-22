package com.algorithm.training.basic;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 反向输出一个四位数
 * 题目描述
 * 将一个四位数，反向输出。
 *
 * 输入描述:
 * 一行，输入一个整数n（1000 <= n <= 9999）。
 * 输出描述:
 * 针对每组输入，反向输出对应四位数。
 *
 * 示例1
 * 输入 1234
 * 输出 4321
 * @Date 2020/3/17 22:18
 * @Version 1.0
 */
public class ReverseOutputNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < 4; i++) {
            System.out.print(num % 10);
            num = num / 10;
        }
    }
}
