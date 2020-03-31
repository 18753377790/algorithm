package com.fundamental.algorithm.classical_algorithm;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 猴子吃桃
 * @Date 2019/11/7 11:13
 * @Version 1.0
 */
public class MonkeyEatPeach {

    /**
     * 猴子吃桃
     * @param day 天数
     * @return 最初桃子数
     */
    private static int monkeyEatPeach(int day) {
        //
        if (day == 1)
            return 1;
        return (monkeyEatPeach(day - 1) + 1) * 2;
    }

    public static void main(String[] args) {
        System.out.println("猴子吃桃问题求解！");
        System.out.println("输入天数：");
        Scanner scanner = new Scanner(System.in);
        // 天数
        int day = scanner.nextInt();
        // 最初桃子数
        int peachNum = monkeyEatPeach(day);
        System.out.printf("最初的桃子数为：%d个", peachNum);
    }
}
