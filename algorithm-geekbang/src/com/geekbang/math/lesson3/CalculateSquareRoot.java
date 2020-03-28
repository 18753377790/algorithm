package com.geekbang.math.lesson3;

/**
 * @Author 李非凡
 * @Description: 计算平方根
 * @Date 2020/3/14 10:42
 * @Version 1.0
 */
public class CalculateSquareRoot {


    public static void main(String[] args) {
        int number = 10;
        double squareRoot = getSquareRoot(number, 0.000001, 10000);
        if (squareRoot == -1.0) {
            System.out.println("请输入大于1的整数");
        } else if (squareRoot == -2.0) {
            System.out.println("未能找到解");
        } else {
            System.out.println(String.format("%d的平方根是%f", number, squareRoot));
        }
    }

    /**
     * 计算大于1的正整数之平方根
     * @param n 待求的数
     * @param deltaThreshold 误差的阈值
     * @param maxTry 二分查找的最大次数
     * @return 平方根的解
     */
    private static double getSquareRoot(int n, double deltaThreshold, int maxTry) {
        // 如果待求的数小于等于1，则不符合，直接返回-1.0
        if (n <= 1) {
            return -1.0;
        }

        double min = 1.0;
        double max = (double)n;

        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            // 求middle的平方
            double square = middle * middle;
            // 计算误差
            double delta = Math.abs((square / n) - 1);
            if (delta <= deltaThreshold) {
                return middle;
            }else {
                if (square > n) {
                    max = middle;
                }else {
                    min = middle;
                }
            }
        }
        //
        return -2.0;
    }
}
