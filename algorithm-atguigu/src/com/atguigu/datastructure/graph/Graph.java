package com.atguigu.datastructure.graph;

import java.util.*;

/**
 * @Author 李非凡
 * @Description: 图
 * 一对一：线性表
 * 一对多：树
 * 多对多：图
 *
 * 图的常用概念、
 * 图：图是一种数据结构，其中结点可以具有零个或多个相邻元素。
 * 顶点（vertex）：图的结点
 * 边（edge）：两个结点（顶点）之间的连接
 * 方向：边的方向
 * 权值：边的长度
 * 路径：
 * 无向图：顶点之间的连接没有方向
 * 有向图：顶点之间的连接有方向
 * 带权图：顶点之间的连接有权值，又称网
 *
 * 图的表示方式：
 * 1.邻接矩阵：二维数组表示
 *   邻接矩阵是表示图形中顶点之间相邻关系的矩阵，对于n个顶点的图而言，矩阵是的row和col表示的是1....n个点。
 *   1表示能够直接连接
 *   0表示不能直接连接
 * 2.邻接表：数组加链表表示
 *   邻接表的实现只关心存在的边，不关心不存在的边。
 *   因此没有空间浪费，邻接表由数组+链表组成
 * @Date 2020/3/8 0:49
 * @Version 1.0
 */
public class Graph {

    /**
     * 存储顶点的集合
     */
    private List<String> vertexList;

    /**
     * 存储图对应的邻接矩阵
     * A->0
     * B->1
     * ...
     */
    private int[][] matrix;

    /**
     * 边的数目
     */
    private int numOfEdges;

    /**
     * 用布尔数组记录某个顶点是否被访问过
     */
    private boolean[] isVisited;

    public Graph(int n) {
        // 初始化矩阵
        matrix = new int[n][n];
        // 初始化顶点集合
        vertexList = new ArrayList<>(n);
        //
        numOfEdges = 0;
        //
        isVisited = new boolean[n];
    }

    /**
     * 返回顶点的个数
     * @return 顶点的个数
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 返回边的个数
     * @return 边的个数
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回顶点下标对应的数据
     * 例：
     * 0 -> A
     * 1 -> B
     * 2 -> C
     * @param index
     * @return
     */
    public String getVertexByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 返回v1和v2之间的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return matrix[v1][v2];
    }

    /**
     * 显示图对应的矩阵
     */
    public void showMatrix() {
        for (int[] array: matrix) {
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 添加顶点（结点）
     * @param vertex 顶点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加顶点（结点）
     * @param vertexArray 顶点数组
     */
    public void insertVertex(String[] vertexArray) {
        vertexList = Arrays.asList(vertexArray);
    }

    /**
     * 添加边
     * @param v1 顶点1的下标，即表示第几个顶点
     * @param v2 顶点2的下标，即表示第几个顶点
     * @param weight 权值，默认是0，v1和v2有连接则为1
     */
    public void insertEdge(int v1, int v2, int weight) {
        // 因为是无向图，所以要写两遍
        matrix[v1][v2] = weight;
        matrix[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 获取第一个邻接结点（顶点）的下标 w
     * @param index
     * @return 如果存在返回对应下标，否则返回-1
     */
    private int getFirstAdjacencyVertex(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (matrix[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点（顶点）的下标来获取下一个邻接结点（顶点）
     * @param v1
     * @param v2
     * @return 如果存在返回对应下标，否则返回-1
     */
    private int getNextAdjacencyVertex(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (matrix[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先搜索
     * @param isVisited 布尔数组记录某个顶点是否被访问过
     * @param index 顶点（结点）的下标，第一次为0
     */
    private void dfs(boolean[] isVisited, int index) {
        // 首先访问该结点（顶点）并输出
        System.out.print(getVertexByIndex(index) + "->");
        // 将该结点设置为已访问
        isVisited[index] = true;
        // 查找结点index的第一个邻接结点
        int adjacencyNode = getFirstAdjacencyVertex(index);
        while (adjacencyNode != -1) {
            if (!isVisited[adjacencyNode]) {
                dfs(isVisited, adjacencyNode);
            }
            // 如果邻接结点已经被访问过
            adjacencyNode = getNextAdjacencyVertex(index, adjacencyNode);
        }
    }

    /**
     * 对dfs进行重载，遍历所有结点并进行dfs
     */
    public void dfs() {
        // 遍历所有结点，进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 广度优先搜索（对一个结点进行广度优先搜索）
     * @param isVisited 布尔数组记录某个顶点是否被访问过
     * @param index 顶点（结点）的下标，第一次为0
     */
    private void bfs(boolean[] isVisited, int index) {
        // 表示队列的头结点对应的下标
        int head;
        // 邻接结点
        int adjacencyNode;
        // 队列，用于记录结点访问的顺序
        Queue<Integer> queue = new LinkedList<>();
        // 访问结点，输出结点信息
        System.out.print(getVertexByIndex(index) + "->");
        // 标记为已访问
        isVisited[index] = true;
        // 将结点加入队列
        queue.add(index);

        while (!queue.isEmpty()) {
            // 取出队列的头结点的下标
            head = queue.remove();
            // 得到第一个邻接结点的下标
            adjacencyNode = getFirstAdjacencyVertex(head);
            // 找到了
            while (adjacencyNode != -1) {
                // 是否访问过
                if (!isVisited[adjacencyNode]) {
                    System.out.print(getVertexByIndex(adjacencyNode) + "->");
                    // 标记已经访问
                    isVisited[adjacencyNode] = true;
                    // 入队
                    queue.add(adjacencyNode);
                }
                // 以head为前驱点，找adjacencyNode后面的下一个邻接结点，这里体现出广度优先
                adjacencyNode = getNextAdjacencyVertex(head, adjacencyNode);
            }
        }
    }

    /**
     * 对bfs进行重载，遍历所有结点并进行bfs
     */
    public void bfs() {
        // 遍历所有结点，进行bfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }
}

