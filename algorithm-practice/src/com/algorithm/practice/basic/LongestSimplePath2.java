package com.algorithm.practice.basic;

/**
 * @Author 李非凡
 * @Description:
 * 练习题1：求有向无环图两点路径的最大值。
 * 思路： 给定有向无环图的矩阵， 从1-n的最长距离，2-n的最长距离...
 * maxLength[i,j]=maxlenth[i,j-1]+length[j]  //length[j]是与终点相连的很多点之一。最大的一个。
 * @Date 2020/2/28 21:54
 * @Version 1.0
 */
public class LongestSimplePath2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,2,3},
                {0,0,2},
                {0,0,0}
        };
        maxLength1(matrix);
    }
    /**
     * 方法1
     * @param matrix 有向无换图的矩阵表示
     */
    public static void maxLength1(int[][] matrix) {
        // 存储i到j的最长距离
        int[][] maxLength = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            // 每个节点到初始节点都为0
            maxLength[i][0] = 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    // 因为无环
                    maxLength[j][i]=0;
                    continue;
                }
                // j到i;
                // 遍历，第i个节点相邻的节点
                int length = matrix[i].length;
                maxLength[j][i]=Integer.MIN_VALUE;
                for (int k = 0; k < i; k++) {
                    int value=maxLength[j][k]+matrix[k][i];
                    if (value > maxLength[j][i]) {
                        maxLength[j][i]=value;
                    }
                }
            }

        }

        for (int[] ints : maxLength) {
            for (int j = 0; j < maxLength[0].length; j++) {
                System.out.print(ints[j] + "        ");
            }
            System.out.println();
        }
    }
}
