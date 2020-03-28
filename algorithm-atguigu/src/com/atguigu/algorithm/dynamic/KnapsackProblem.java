package com.atguigu.algorithm.dynamic;

/**
 * @Author 李非凡
 * @Description: 背包问题
 *
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
        // 物品重量
        int[] weight = {1, 4, 3};
        // 物品价值
        int[] value= {1500, 3000, 2000};
        // 物品个数
        int num = value.length;
        // 背包容量
        int capacity = 4;
    }

    private static void knapsack() {
        int[][] v = new int[+1][+1];
    }
}
