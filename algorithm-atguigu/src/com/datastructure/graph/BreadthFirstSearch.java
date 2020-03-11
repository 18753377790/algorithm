package com.datastructure.graph;

/**
 * @Author 李非凡
 * @Description: 广度优先搜索
 * 广度优先搜索介绍
 * 类似于一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，
 * 以便按这个顺序来访问这些结点的邻接结点
 *
 * 广度优先搜索步骤
 * 1.访问初始结点v并标记结点v为已访问。
 * 2.结点v入队列
 * 3.当队列非空时，继续执行，否则算法结束。
 * 4.出队列，取得队头结点u。
 * 5.查找结点u的第一个邻接结点w。
 * 6.若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
 *   6.1 若结点w尚未被访问，则访问结点w并标记为已访问。
 *   6.2 结点w入队列
 *   6.3 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
 * @Date 2020/3/11 15:01
 * @Version 1.0
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        // 结点的个数
        int n = 8;
        // 顶点的值
        String[] vertexArray = {"1", "2", "3", "4", "5", "6", "7", "8"};
        // 创建图对象
        Graph graph = new Graph(n);

        // 相当于循环添加顶点
       graph.insertVertex(vertexArray);

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

        System.out.println("广度优先搜索：");
        graph.bfs();
    }
}
