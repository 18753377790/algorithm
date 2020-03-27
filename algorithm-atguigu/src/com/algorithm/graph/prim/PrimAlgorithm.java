package com.algorithm.graph.prim;

/**
 * @Author 李非凡
 * @Description: 普利姆算法
 * 一、最小生成树
 * 修路问题本质就是就是最小生成树问题。
 * 最小生成树(Minimum Cost Spanning Tree)，简称MST。
 * 给定一个带权的无向连通图,如何选取一棵生成树,使树上所有边上权的总和为最小,这叫最小生成树
 * <p>
 * 特点：
 * N个顶点，一定有N-1条边
 * 包含全部顶点
 * N-1条边都在图中
 * <p>
 * 举例说明(如图:)
 * 求最小生成树的算法主要是普里姆算法和克鲁斯卡尔算法
 * <p>
 * 二、普利姆算法
 * @Date 2020/3/13 11:32
 * @Version 1.0
 */
public class PrimAlgorithm {

    /**
     *
     */
    private static final int N = Integer.MAX_VALUE;

    public static void main(String[] args) {
        //
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int numOfVertex = vertexes.length;
        // 使用二维数组表示邻接矩阵的关系，使用Integer.MAX_VALUE这个大数表示两个点不联通
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };
        // 创建Graph对象
        Graph graph = new Graph(numOfVertex);
        // 创建一个MST对象
        MinimumSpanningTree mst = new MinimumSpanningTree();
        mst.createGraph(graph, numOfVertex, vertexes, matrix);
        // 输出
        mst.showGraph(graph);

        mst.prim(graph, 0);
    }
}
