package com.atguigu.algorithm.graph.dijkstra;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description: 创建图
 * @Date 2020/3/13 18:25
 * @Version 1.0
 */
public class Graph {

    /**
     * 顶点数组
     */
    private char[] vertexes;

    /**
     * 邻接矩阵
     */
    private int[][] matrix;

    /**
     * 已经访问的顶点的集合
     */
    private VisitedVertex vv;

    /**
     * 构造器
     * @param vertexes
     * @param matrix
     */
    public Graph(char[] vertexes, int[][] matrix) {
        this.vertexes = vertexes;
        this.matrix = matrix;
    }

    /**
     * 显示结果
     */
    public void showDijkstra() {
        vv.show();
    }

    /**
     * 显示图
     */
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 迪杰斯特拉算法实现
     * @param index 表示出发顶点对应的下标
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertexes.length, index);
        // 更新index顶点到周围顶点的距离和前驱顶点
        update(index);
        for(int j = 1; j < vertexes.length; j++) {
            // 选择并返回新的访问顶点
            index = vv.updateArr();
            // 更新index顶点到周围顶点的距离和前驱顶点
            update(index);
        }
    }

    /**
     * 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
     * @param index
     */
    private void update(int index) {
        int len = 0;
        // 根据遍历我们的邻接矩阵的  matrix[index]行
        for(int j = 0; j < matrix[index].length; j++) {
            // len 含义是 : 出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + matrix[index][j];
            // 如果j顶点没有被访问过，并且 len 小于出发顶点到j顶点的距离，就需要更新
            if(!vv.in(j) && len < vv.getDis(j)) {
                // 更新j顶点的前驱为index顶点
                vv.updatePre(j, index);
                // 更新出发顶点到j顶点的距离
                vv.updateDis(j, len);
            }
        }
    }
}
