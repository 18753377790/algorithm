package com.algorithm.graph.prim;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description: 最小生成树
 * @Date 2020/3/13 18:32
 * @Version 1.0
 */
public class MinimumSpanningTree {

    /**
     * 创建图的邻接矩阵
     *
     * @param graph       图对象
     * @param numOfVertex 图对应的顶点个数
     * @param vertexes    图的各个顶点的值
     * @param matrix      图的邻接矩阵
     */
    public void createGraph(Graph graph, int numOfVertex, char[] vertexes, int[][] matrix) {
        graph.setVertexes(vertexes);
        graph.setMatrix(matrix);
    }

    /**
     * 显示图的邻接矩阵
     *
     * @param graph 图对象
     */
    public void showGraph(Graph graph) {
        for (int[] link : graph.getMatrix()) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 普利姆算法，得到最小生成树
     *
     * @param graph  图
     * @param vertex 最小生成树的起点（图的某个顶点）
     */
    public void prim(Graph graph, int vertex) {
        int[][] matrix = graph.getMatrix();
        char[] vertexes = graph.getVertexes();

        /*
         visited标记结点（顶点）是否被访问过
         visited[] 默认元素的值都是0, 表示没有访问过
         */
        int[] visited = new int[graph.getNumOfVertex()];

        // 把当前结点标记为已访问
        visited[vertex] = 1;
        // v1和v2记录两个顶点的下标
        int v1 = -1;
        int v2 = -1;
        // 将minWeight初始成一个大数，后面在遍历过程中，会被替换
        int minWeight = Integer.MAX_VALUE;
        // 
        for (int k = 1; k < graph.getNumOfVertex(); k++) {
            //
            for (int i = 0; i < graph.getNumOfVertex(); i++) {
                for (int j = 0; j < graph.getNumOfVertex(); j++) {
                    if (visited[i] == 1 && visited[j] == 0 && matrix[i][j] < minWeight) {
                        minWeight = matrix[i][j];
                        v1 = i;
                        v2 = j;
                    }
                }
            }
            //
            System.out.println("边<" + vertexes[v1] + "," + vertexes[v2] + "> 权值：" + minWeight);
            //
            visited[v2] = 1;
            //
            minWeight = Integer.MAX_VALUE;
        }
    }
}
