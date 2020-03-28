package com.atguigu.algorithm.graph.prim;

/**
 * @Author 李非凡
 * @Description: 图
 * @Date 2020/3/13 18:20
 * @Version 1.0
 */
public class Graph {

    /**
     * 表示图的顶点（结点）个数
     */
    private int numOfVertex;

    /**
     * 存放顶点（结点）数据
     */
    private char[] vertexes;

    /**
     * 邻接矩阵，存放边
     */
    private int[][] matrix;

    public Graph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        vertexes = new char[numOfVertex];
        matrix = new int[numOfVertex][numOfVertex];
    }

    public int getNumOfVertex() {
        return numOfVertex;
    }

    public void setNumOfVertex(int numOfVertex) {
        this.numOfVertex = numOfVertex;
    }

    public char[] getVertexes() {
        return vertexes;
    }

    public void setVertexes(char[] vertexes) {
        this.vertexes = vertexes;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
