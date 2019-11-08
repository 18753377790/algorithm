package com.algorithm.classical_algorithm;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 舍罕王赏麦
 * @Date 2019/11/7 14:00
 * @Version 1.0
 */
public class KingPraisedWheat {

    /**
     * 赏麦
     * 等比数列：1,2,4,8,...2^63
     * 通向公式：An=2^(n-1)
     * 前n项和公式：Sn=1+2+4+8+...2^63=2^n-1
     * @param n 棋盘格数
     * @return 麦子总数
     */
    private static double praisedWheat(int n) {
        // 起始棋盘格
        int temp = 1;
        // 麦子总数
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            temp *= 2;
            sum += temp;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("舍罕王赏麦问题求解！");
        System.out.println("输入棋盘格总数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = praisedWheat(n);
        System.out.printf("舍罕王赏总麦粒数为：%f粒", sum);
    }
}
