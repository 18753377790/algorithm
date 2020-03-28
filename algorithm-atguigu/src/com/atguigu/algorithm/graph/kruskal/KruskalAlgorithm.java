package com.atguigu.algorithm.graph.kruskal;

/**
 * @Author 李非凡
 * @Description: 克鲁斯卡尔算法
 * @Date 2020/3/13 11:32
 * @Version 1.0
 */
public class KruskalAlgorithm {

    /**
     * 整型的最大值表示两个顶点不能联通
     */
    private static final int N = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 克鲁斯卡尔算法的邻接矩阵
        int[][] matrix = {
                {0, 12, N, N, N, 16, 14},
                {12, 0, 10, N, N, 7, N},
                {N, 10, 0, 3, 5, 6, N},
                {N, N, 3, 0, 4, N, N},
                {N, N, 5, 4, 0, 2, 8},
                {16, 7, 6, N, 2, 0, 9},
                {14, N, N, N, 8, 9, 0}
        };
        // 创建Graph对象实例
        Graph graph = new Graph(vertexes, matrix);

        MinimumSpanningTree mst = new MinimumSpanningTree();
        mst.showGraph(graph);
    }
}
