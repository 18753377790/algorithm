package com.fundamental.algorithm.lb.graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author 李非凡
 * @Description:
 * 广度搜索算法（breadth first search）
 * 非递归实现
 * 一般涉及到能不能到达或者所有的路径就考虑bfs，bfs效率高于dfs
 *
 * 图论经典问题：迷宫问题
 * @Date 2019/10/27 15:01
 * @Version 1.0
 */
public class BreadthFirstSearch {

    private Graph graph = new Graph();

    private Point point = new Point();

    /**
     * 广度优先搜索
     * X，Y表示起始位置
     * @param startX 起始点的横坐标
     * @param startY 起始点的纵坐标
     */
    private void bfs(int startX, int startY){
        graph.mark[startX][startY] = true;
        Queue<Point> queue = new ArrayBlockingQueue<>(graph.n * graph.m);
        // 起始点
        Point startPoint = new Point();
        startPoint.x = startX;
        startPoint.y = startY;
        // 起始点加入队列
        queue.add(startPoint);
        // 定义一个方向向量，表示前后左右（二维数组）
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            //
            Point currentPoint = queue.poll();

            for (int i = 0; i < next.length; i++) {
                int nextX = currentPoint.x + next[i][0];
                int nextY = currentPoint.y + next[i][1];
            }
        }
    }

    public static void main(String[] args) {

    }
}
