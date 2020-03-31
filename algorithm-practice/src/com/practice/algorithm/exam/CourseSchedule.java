package com.practice.algorithm.exam;

import java.util.*;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/31 7:44
 * @Version 1.0
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 0},
                {2, 0}
        };

        int[][] matrix2 = {
                {1, 0},
                {2, 1}
        };

        for (int[] array : matrix2) {
            System.out.println(Arrays.toString(array));
        }

        int num = 3;

        System.out.println("num=" + 3);
        CourseSchedule courseSchedule = new CourseSchedule();
        int[] order = courseSchedule.findOrder(num, matrix1);
        int[] order2 = courseSchedule.findOrder2(num, matrix2);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化图
        Map<Integer, List<Integer>> map = new HashMap<>(16);
        // 存储每个结点的入度
        int[] inDegree = new int[numCourses];
        // 加入结果集合，从后往前依次加入入度为0的点
        int[] res = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int first = prerequisite[0];
            int second = prerequisite[1];
            if (!map.containsKey(first)) {
                map.put(first, new ArrayList<>());
            }
            map.get(first).add(second);
            // 入度加一，从first->second
            inDegree[second]++;
        }
        int index = numCourses - 1;
        // 存储所有入度为0的结点
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                res[index--] = i;
            }
        }
        // 用来计算拓扑排序的结点个数
        while (!q.isEmpty()) {
            // 获取第一格入度为0的结点
            int val = q.poll();
            // 判断很关键
            if (!map.containsKey(val)) {
                continue;
            }
            // 获取val的临结点
            List<Integer> tmp = map.get(val);
            for (int idx : tmp) {
                // 把所有的以val为开头的入度减一
                inDegree[idx]--;
                // 如果入度为0，则把该结点加入队列中
                if (inDegree[idx] == 0) {
                    q.offer(idx);
                    res[index--] = idx;
                }
            }
        }

        if (index != -1) {
            return new int[0];
        } else {
            for (int i = 0; i < res.length; i++) {
                if (i == res.length - 1){
                    System.out.print(res[i]);
                }else {
                    System.out.print(res[i] + "->");
                }
            }
            return res;
        }
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mapList = new HashMap<>(32);
        int[] inDegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            List<Integer> list = mapList.getOrDefault(src, new ArrayList<>(10));
            list.add(dest);
            mapList.put(src, list);

            // Record in-degree of each vertex
            inDegree[dest] += 1;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!queue.isEmpty()) {
            int node = queue.remove();
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each neighbor by 1
            if (mapList.containsKey(node)) {
                for (Integer neighbor : mapList.get(node)) {
                    inDegree[neighbor]--;

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
            for (int j = 0; j < topologicalOrder.length; j++) {
                if (j != topologicalOrder.length - 1){
                    System.out.print(topologicalOrder[j] + "->");
                }else {
                    System.out.print(topologicalOrder[j]);
                }
            }
            return topologicalOrder;
        }

        return new int[0];
    }


}
