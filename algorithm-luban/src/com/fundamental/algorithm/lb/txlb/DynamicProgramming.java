package com.fundamental.algorithm.lb.txlb;

/**
 * @Author 李非凡
 * @Description:
 * 动态规划（最难的算法之一）
 * 核心思想：
 * 分解子问题，通过局部最大值得到全局最大。
 *
 * 背包问题
 * 小偷去某商店盗窃，背有一个背包，容量是50kg，现在有以下物品（物品不能切分），请问
 * 小偷应该怎么拿才能得到最大的价值？
 * 	       重量   价值   性价比
 * 物品1   10kg   60元   6元/kg
 * 物品2   20kg   100元  5元/kg
 * 物品3   40kg   120元  3元/kg
 *
 * 贪心算法和动态规划的主要
 * @Date 2019/9/15 10:54
 * @Version 1.0
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        // 每个物品的价值/元
        int[] value = {60, 100, 120};
        // 每个物品的重量/kg，和上面的一一对应
        int[] weight = {10, 20, 40};
        // 袋子的容量/kg
        int capacity = 50;
        // 物品的个数/个
        int number = 3;
        // 表示分割成一个小的表格/矩阵
        int[][] matrix = new int[number + 1][capacity + 1];

        // 表示物品往里面加
        for (int i = 1; i <= number; i++) {
            // 袋子在每一个容积下所装的最大的钱
            for (int cw = 1; cw <= capacity; cw++) {
                // 表示这个物品可以装
                if (weight[i - 1] <= cw){
                    // 核心算法
                    matrix[i][cw] = Math.max(
                            // 我装新加的物品
                            value[i - 1] + matrix[i - 1][cw - weight[i - 1]],
                            // 我不装新加的物品
                            matrix[i - 1][cw]
                    );
                }else {
                    // 新加的这个装不下 ，那么就取前一个物品装值
                    matrix[i][cw] = matrix[i - 1][cw];
                }
            }
        }
        // 袋子能装的最大价值就是表格/矩阵的最后一个数
        System.out.println("袋子能装的最大价值：" + matrix[number][capacity]);
    }
}
