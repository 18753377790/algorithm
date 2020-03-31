package com.atguigu.algorithm.dynamic;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description: 背包问题
 * 动态规划算法最佳实践-背包问题
 *
 * i表示二维数组的行，j表示二维数组的列，w表示物品总量数组weight
 * 1.v[i][0]=v[0][j]=0
 * 2.当weight[i]>j时
 * 3.
 * @Date 2020/3/12 11:11
 * @Version 1.0
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        // 物品重量/磅
        int[] weight = {1, 4, 3};
        // 物品价值/元
        int[] value = {1500, 3000, 2000};
        // 物品个数/个
        int number = value.length;
        // 背包容量/磅
        int capacity = 4;

        knapsack(weight, value, number, capacity);
    }

    /**
     * 背包问题求解
     * @param weight 物品重量
     * @param value 物品价值
     * @param number 物品个数
     * @param capacity 背包容量
     */
    private static void knapsack(int[] weight, int[] value, int number, int capacity) {
        // 创建二维数组
        int[][] matrix = new int[number + 1][capacity + 1];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (weight[i - 1] > j) {
                    matrix[i][j] = matrix[i - 1][j];
                }else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], value[i - 1] + matrix[i - 1][j - weight [i - 1]]);
                }
            }
        }

        print(matrix);
    }

    /**
     * 打印二维数组
     * @param matrix 二维数组
     */
    private static void print(int[][] matrix) {
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }
}
