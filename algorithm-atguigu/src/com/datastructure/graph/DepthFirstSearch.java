package com.datastructure.graph;

/**
 * @Author 李非凡
 * @Description: 深度优先搜索
 * 深度优先搜索介绍
 * 1.深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点，
 *   深度优先遍历的策略就是首先访问第一个邻接结点，
 *   然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点，
 *   可以这样理解：每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
 * 2.深度优先搜索是优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问。
 * 3.深度优先搜索是一个递归的过程
 *
 * 深度优先搜索步骤
 * 1.访问初始结点v，并标记结点v为已访问（boolean数组）。
 * 2.查找结点v的第一个邻接结点w。
 * 3.若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
 * 4.若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
 * 5.若w被访问过，查找结点v的w邻接结点的下一个邻接结点，转到步骤3。
 * @Date 2020/3/11 15:00
 * @Version 1.0
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        // 结点的个数
        int n = 8;
        // 顶点的值
        String[] vertexArray = {"1", "2", "3", "4", "5", "6", "7", "8"};
        // 创建图对象
        Graph graph = new Graph(n);

        // 相当于循环添加顶点
        for(String vertex : vertexArray) {
            graph.insertVertex(vertex);
        }

        // 添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        // 显示邻接矩阵
        graph.showMatrix();

        System.out.println("深度优先搜索：");
        graph.dfs();
    }
}
