package com.algorithm.graph.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 迪杰斯特拉算法
 * 应用场景-最短路径问题
 *
 * 迪杰斯特拉(Dijkstra)算法介绍
 * 迪杰斯特拉(Dijkstra)算法是典型最短路径算法，用于计算一个结点到其他结点的最短路径。 
 * 它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止。
 *
 *
 * @Date 2020/3/13 11:33
 * @Version 1.0
 */
public class DijkstraAlgorithm {

    public static void main(String[] args) throws IOException{

        String filePath = "C:/Users/李非凡/Desktop/input.txt";
        File file = new File(filePath);
        String tempString;
        List<String> list = new ArrayList<>();

        int line = 1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
        while ((tempString = reader.readLine()) != null) {
            System.out.println("Line" + line + ":" + tempString);
            line ++;
            list.add(tempString);
        }

//        System.out.println(list);

        List<String[]> lists = new ArrayList<>();

        reader.close();

        char[] vertex = {'0', '1', '2', '3', '4', '5'};
//        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        // 邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        // 表示不可以连接
        final int N = 65535;
//        matrix[0] = new int[]{N,5,7,N,N,N,2};
//        matrix[1] = new int[]{5,N,N,9,N,N,3};
//        matrix[2] = new int[]{7,N,N,N,8,N,N};
//        matrix[3] = new int[]{N,9,N,N,N,4,N};
//        matrix[4] = new int[]{N,N,8,N,N,5,4};
//        matrix[5] = new int[]{N,N,N,4,5,N,6};
//        matrix[6] = new int[]{2,3,N,N,4,6,N};

        int index01 = (int) getEdges(1000, 2400, 2800, 3000);
        int index03 = (int) getEdges(1000, 2400, 4000, 0);
        int index12 = (int) getEdges(2800, 3000, 2400, 2500);
        int index14 = (int) getEdges(2800, 3000, 4500, 3800);
        int index24 = (int) getEdges(2400, 2500, 4500, 3800);
        int index23 = (int) getEdges(2400, 2500, 4000, 0);
        int index25 = (int) getEdges(2400, 2500, 6000, 1500);
        int index35 = (int) getEdges(4000, 0, 6000, 1500);
        int index45 = (int) getEdges(4500, 3800, 6000, 1500);

        matrix[0] = new int[] {N, index01, N, index03, N, N};
        matrix[1] = new int[] {index01, N, index12, N, index14, N};
        matrix[2] = new int[] {N, index12, N, index23, index24, index25};
        matrix[3] = new int[] {N, N, index23, N, N, index35};
        matrix[4] = new int[] {N, index14, index24, N, N, index45};
        matrix[5] = new int[] {N, N, index25, index35, index45, N};

        // 出发顶点对应的下标
        int index = new Scanner(System.in).nextInt();
        // 创建 Graph对象
        Graph graph = new Graph(vertex, matrix);
        // 测试, 看看图的邻接矩阵是否ok
//        graph.showGraph();
        // 测试迪杰斯特拉算法 // C
//        graph.dsj(index);
//        graph.showDijkstra();
    }

    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    private static double getEdges(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
