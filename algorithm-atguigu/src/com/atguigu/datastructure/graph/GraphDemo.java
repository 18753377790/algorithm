package com.atguigu.datastructure.graph;

/**
 * @Author 李非凡
 * @Description: 图的演示（无向图的邻接矩阵表示）
 * @Date 2020/3/11 16:53
 * @Version 1.0
 */
public class GraphDemo {

    public static void main(String[] args) {
        // 结点的个数
        int n = 5;
        // 顶点的值
        String[] vertexArray = {"A", "B", "C", "D", "E"};
        // 创建图对象
        Graph graph = new Graph(n);
        /*
         相当于循环添加顶点
         for(String vertex : vertexArray)
         graph.insertVertex(vertex)
         */
        graph.insertVertex(vertexArray);
        /*
         添加边
         A-B,A-C,B-C,B-D,B-E
         0-1,0-2,1-2,1-3,1-4
         */
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        // 显示邻接矩阵
        graph.showMatrix();

        System.out.println("深度优先搜索：");
        graph.dfs();

        System.out.println("广度优先搜索：");
        graph.bfs();
    }
}
