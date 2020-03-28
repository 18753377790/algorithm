package com.atguigu.algorithm.graph.dijkstra;

/**
 * @Author 李非凡
 * @Description: 迪杰斯特拉算法
 * 应用场景-最短路径问题
 *
 * 迪杰斯特拉(Dijkstra)算法介绍
 * 迪杰斯特拉(Dijkstra)算法是典型最短路径算法，用于计算一个结点到其他结点的最短路径。 
 * 它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止。
 * @Date 2020/3/13 11:33
 * @Version 1.0
 */
public class DijkstraAlgorithm {

    public static void main(String[] args) {
        char[] vertexes = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        // 邻接矩阵
        int[][] matrix = new int[vertexes.length][vertexes.length];
        // 表示不可以连接
        final int N = 65535;
//        matrix[0] = new int[]{N,5,7,N,N,N,2};
//        matrix[1] = new int[]{5,N,N,9,N,N,3};
//        matrix[2] = new int[]{7,N,N,N,8,N,N};
//        matrix[3] = new int[]{N,9,N,N,N,4,N};
//        matrix[4] = new int[]{N,N,8,N,N,5,4};
//        matrix[5] = new int[]{N,N,N,4,5,N,6};
//        matrix[6] = new int[]{2,3,N,N,4,6,N};
    }
}
