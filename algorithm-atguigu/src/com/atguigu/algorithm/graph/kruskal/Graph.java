package com.atguigu.algorithm.graph.kruskal;

/**
 * @Author 李非凡
 * @Description: 图
 * @Date 2020/3/25 12:27
 * @Version 1.0
 */
public class Graph {

    /**
     * 边的数目
     */
    private int numOfEdge;

    /**
     * 顶点数组
     */
    private char[] vertexes;

    /**
     * 邻接矩阵
     */
    private int[][] matrix;

    /**
     * 构造器初始化顶点和边的个数
     *
     * @param vertexes 顶点数组
     * @param matrix   邻接矩阵
     */
    public Graph(char[] vertexes, int[][] matrix) {
        this.vertexes = vertexes;
        this.matrix = matrix;
    }

    public int getNumOfEdge() {
        return numOfEdge;
    }

    public void setNumOfEdge(int numOfEdge) {
        this.numOfEdge = numOfEdge;
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

    /**
     * 打印邻接矩阵
     */
    public void print() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = 0; j < vertexes.length; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
