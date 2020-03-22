package com.math;

/**
 * @Author 李非凡
 * @Description: 计算平方根
 * @Date 2020/3/14 10:42
 * @Version 1.0
 */
public class CalculateSquareRoot {

    public static void main(String[] args) {

    }

    /**
     *
     * @param n
     * @param deltaThreshold
     * @param maxTry
     * @return
     */
    private static double getSquareRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }

        double min = 1.0;
        double max = (double)n;
        for (int i = 0; i < maxTry; i++) {
            
        }
        return 0;
    }
}
