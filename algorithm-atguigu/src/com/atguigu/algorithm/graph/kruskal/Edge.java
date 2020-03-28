package com.atguigu.algorithm.graph.kruskal;

/**
 * @Author 李非凡
 * @Description: 边
 * 创建一个类Edge ，它的对象实例就表示一条边
 * @Date 2020/3/28 10:59
 * @Version 1.0
 */
public class Edge {

    /**
     * 边的起点
     */
    private char start;

    /**
     * 边的终点
     */
    private char end;

    /**
     * 边的权值
     */
    private int weight;

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
