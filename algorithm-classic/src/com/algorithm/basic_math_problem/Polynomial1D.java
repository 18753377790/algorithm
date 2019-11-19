package com.algorithm.basic_math_problem;

/**
 * @Author 李非凡
 * @Description:
 * 一维多项式
 * @Date 2019/11/19 16:46
 * @Version 1.0
 */
public class Polynomial1D {

    /**
     *
     * @param array
     * @param n
     * @param x
     * @return
     */
    private static double polynomial1D(double[] array, int n, double x) {
        double result = array[n - 1];
        for (int i = n - 2; i >= 0; i--)
            result = result * x + array[i];
        return result;
    }

    public static void main(String[] args) {

    }
}
