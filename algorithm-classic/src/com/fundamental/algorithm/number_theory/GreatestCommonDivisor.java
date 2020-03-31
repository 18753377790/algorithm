package com.fundamental.algorithm.number_theory;

/**
 * @Author 李非凡
 * @Description:
 * 最大公约数（GCD）
 * @Date 2019/11/19 18:19
 * @Version 1.0
 */
public class GreatestCommonDivisor {

    /**
     * 辗转相除法，即欧几里得算法（Euclidean algorithm）
     * @param a
     * @param b
     * @return
     */
    private static int divisionAlgorithm(int a, int b) {
        int m, n;
        if (a > b) {
            m = a;
            n = b;
        }else {
            m = b;
            n = a;
        }
        // 余数
        int remainder = m % n;
        // 辗转相除
        while (remainder != 0) {
            m = n;
            n = remainder;
            remainder = m % n;
        }
        return n;
    }

    private static int steinAlgorithm() {
        return 0;
    }

    public static void main(String[] args) {

    }
}
