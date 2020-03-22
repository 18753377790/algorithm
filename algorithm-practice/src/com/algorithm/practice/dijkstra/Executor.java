package com.algorithm.practice.dijkstra;

import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * @Author 靳君
 * @Description:
 *
 * @Date 2020/3/20 22:38
 * @Version 1.0
 */
public class Executor {

    public static final int M = -1;

    /**
     *
     * @param start
     * @param end
     * @param mVexs
     * @param mMatrix
     */
    public static void dijkstra(int start, int end, String[] mVexs, HashMap<Point, Double> mMatrix) {
        //寻找最短路径
        double[] shortPath = dijkstra_alg(start, end, mMatrix, mVexs.length);

        if (shortPath == null) {
            return;
        }
    }

    /**
     *
     * @param mMatrix
     * @param orig
     * @param i
     * @return
     */
    private static double nget(HashMap<Point, Double> mMatrix, int orig, int i){
        Double orig_i_value = mMatrix.get(new Point(orig,i));
        if(orig_i_value == null){
            orig_i_value = (orig == i )? 0.0: Double.MAX_VALUE;
        }
        return orig_i_value;
    }

    /**
     * 迪杰斯特拉算法
     * @param orig
     * @param end
     * @param mMatrix
     * @param mVexSize
     * @return
     */
    private static double[] dijkstra_alg(int orig, int end,HashMap<Point,Double> mMatrix,int mVexSize) {
        // 存放从start到其他节点的最短路径
        double[] shortest = new double[mVexSize];
        // 标记当前该顶点的最短路径是否已经求出，true表示已经求出
        boolean[] visited = new boolean[mVexSize];
        String[] path = new String[mVexSize];
        // TODO Auto-generated method stub
        for (int i = 0; i < mVexSize; i++) {
            Double orig_i_value = nget(mMatrix,orig,i);
            shortest[i] = orig_i_value;
            path[i] = new String(orig + "--->" + i);
        }
        visited[orig] = true;
        // 处理从源点到其余顶点的最短路径
        for (int i = 0; i < mVexSize; ++i) {
            double min = Double.MAX_VALUE;
            int index = -1;
            // 比较从源点到其余顶点的路径长度
            for (int j = 0; j < mVexSize; ++j) {
                // 从源点到j顶点的最短路径还没有找到
                if (visited[j]==false) {
                    // 从源点到j顶点的路径长度最小
                    if (shortest[j] < min) {
                        index = j;
                        min = shortest[j];
                    }
                }
            }
            //找到源点到索引为index顶点的最短路径长度
            if(index != -1) {
                visited[index] = true;
            }
            // 更新当前最短路径及距离
            for (int w = 0; w < mVexSize; w++)
                if (visited[w] == false) {
                    if (nget(mMatrix,index,w) != Double.MAX_VALUE
                            && (min + nget(mMatrix,index,w) < shortest[w])){
                        shortest[w] = min + nget(mMatrix,index,w);
                        path[w] = path[index] + "--->" + w;
                    }
                }
        }

        DecimalFormat df = new DecimalFormat("#.0");
//        System.out.println(df.format(shortest[end]));
        System.out.println("from " + (orig) + " to " + (end) + " path: "+ path[end]+" | shortest roots; " + df.format(shortest[end]));

        return shortest;
    }
}