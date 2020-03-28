package com.practice.algorithm.hard;

/**
 * @Author 李非凡
 * @Description: 有向无环图的最长简单路径
 * @Date 2020/3/2 13:00
 * @Version 1.0
 */
public class LongestSimplePath {

    /**
     *
     */
    private static final int MAX = 65535;

    /**
     *
     */
    private static int[] pathStore = new int[20];

    /**
     *
     * @param graph
     */
    private static void printGraph(int[][] graph) {
        for (int[] row : graph) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     *
     * @param graph
     * @param length
     * @param origin
     * @param destin
     * @return
     */
    private static int graphPathLongest(int[][] graph, int length, int origin, int destin) {
        int pathLength = -1;
        for(int i = 0; i < length; i++ ){
            if(graph[origin][i] != 0 && graph[origin][i] != MAX && origin != destin) {
                if(graphPathLongest(graph, length, i, destin) + graph[origin][i] > pathLength) {
                    pathLength = graphPathLongest(graph, length, i, destin) + graph[origin][i];
                    pathStore[origin] = i;
                }
            } else if(origin == destin) {
                pathStore[origin] = destin;
                pathLength = Math.max(0, pathLength);
            }
        }
        return pathLength;
    }

    /**
     *
     * @param origin
     * @param destin
     */
    private static void printfPath(int origin, int destin) {
        int n = origin;
        System.out.println("the longest path in Graph from node " + origin + " to node " + destin);
        System.out.printf("%d", origin);
        while(n != destin){
            n = pathStore[n];
            System.out.printf("->%d", n);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[5][5];
        graph[0][0] = 0;
        graph[0][4] = 6;
        graph[1][0] = 9;
        graph[1][1] = 0;
        graph[1][2] = 3;
        graph[2][0] = 10;
        graph[2][2] = 0;
        graph[2][3] = 5;
        graph[3][3] = 0;
        graph[3][4] = 1;
        graph[4][4] = 0;
        System.out.println("The graph is:");
        printGraph(graph);
        System.out.println("The longest path value:" + graphPathLongest(graph,5,1,4));
        printfPath(1,4);
    }
}
