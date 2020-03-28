package com.atguigu.algorithm.graph.kruskal;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description: 最小生成树
 * @Date 2020/3/28 9:51
 * @Version 1.0
 */
public class MinimumSpanningTree {

    /**
     * 显示图的邻接矩阵（打印邻接矩阵）
     *
     * @param graph 图对象
     */
    public void showGraph(Graph graph) {
        for (int[] link : graph.getMatrix()) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 对边进行排序处理
     * @param edges 边的集合
     */
    private void sortEdge(Edge[] edges) {
        Arrays.sort(edges);
    }

    /**
     * 获取顶点的位置
     * @param vertex 顶点的值
     * @return 对应的下标
     */
    private int getPosition(char[] vertexes, char vertex) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == vertex) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @return
     */
    private Edge[] getEdges() {
        return null;
    }
}
