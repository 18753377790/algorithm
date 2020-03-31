package com.fundamental.algorithm.lb.graph;

/**
 * @Author 李非凡
 * @Description:
 * 深度搜索算法（depth first search）
 * 回溯算法，递归实现
 * 一般涉及到最快到达或者最短路径就考虑用dfs
 *
 * 图论经典问题：迷宫问题
 * @Date 2019/10/27 15:01
 * @Version 1.0
 */
public class DepthFirstSearch {

    private Graph graph = new Graph();

    /**
     * 深度优先搜索
     * X，Y表示起始位置（你的位置），step表示步数
     * @param startX
     * @param startY
     * @param step
     */
    private void dfs(int startX, int startY, int step){
        // 定义一个方向向量，表示前后左右（二维数组）
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //
        if (startX == graph.dx && startY == graph.dy){
            //

        }

        for (int i = 0; i < next.length; i++) {
            int nextX = startX + next[i][0];
            int nextY = startY + next[i][1];
            //
            if (nextX < 1 || nextX > graph.n) {
                continue;
            }
            //
            if (graph.data[nextX][nextY] == 0 && !graph.mark[nextX][nextY]) {

            }
        }
    }

    public static void main(String[] args) {

    }
}
