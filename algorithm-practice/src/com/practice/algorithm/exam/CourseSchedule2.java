package com.practice.algorithm.exam;

import java.util.*;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/31 9:42
 * @Version 1.0
 */
public class CourseSchedule2 {

    private static final int WHITE = 1;
    private static final int GRAY = 2;
    private static final int BLACK = 3;

    private boolean isPossible;
    private Map<Integer, Integer> color;
    private Map<Integer, List<Integer>> adjList;
    private List<Integer> topologicalOrder;

    private void init(int numCourses) {
        isPossible = true;
        color = new HashMap<>(16);
        adjList = new HashMap<>(16);
        topologicalOrder = new ArrayList<>(10);

        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }
    }

    private void dfs(int node) {

        // Don't recurse further if we found a cycle already
        if (!isPossible) {
            return;
        }

        // Start the recursion
        color.put(node, GRAY);

        // Traverse on neighboring vertices
        for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GRAY) {
                // An edge to a GRAY vertex represents a cycle
                isPossible = false;
            }
        }

        // Recursion ends. We mark it as black
        color.put(node, BLACK);
        topologicalOrder.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        init(numCourses);

        // Create the adjacency list representation of the graph
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }

        int[] order;
        if (isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }

        return order;
    }

    public static void main(String[] args) {
        int[][] matrix3 = {
                {1, 0},
                {2, 0}
        };

        int[][] matrix4 = {
                {1, 0},
                {2, 1}
        };

        for (int[] array : matrix4) {
            System.out.println(Arrays.toString(array));
        }

        int num = 3;

        System.out.println("num=" + 3);
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        int[] order = courseSchedule2.findOrder(num, matrix4);
        for (int i = 0; i < order.length; i++) {
            if (i != order.length - 1){
                System.out.print(order[i] + "->");
            }else {
                System.out.print(order[i]);
            }
        }
    }
}

//class Solution {
//    private static final int ONE = 1;
//    private static final int TWO = 2;
//    private static final int THREE = 3;
//
//    private boolean check;
//    private Map<Integer, Integer> number;
//    private Map<Integer, List<Integer>> tempList;
//    private List<Integer> courseOrder;
//
//    private void init(int courses) {
//        check = true;
//        number = new HashMap<>();
//        tempList = new HashMap<>();
//        courseOrder = new ArrayList<>();
//
//        for (int i = 0; i < courses; i++) {
//            number.put(i, ONE);
//        }
//    }
//
//    private void dfs(int node) {
//        if (!check) {
//            return;
//        }
//        number.put(node, TWO);
//        for (Integer neighbor : tempList.getOrDefault(node, new ArrayList<>())) {
//            if (number.get(neighbor) == ONE) {
//                dfs(neighbor);
//            } else if (number.get(neighbor) == TWO) {
//                check = false;
//            }
//        }
//
//        number.put(node, THREE);
//        courseOrder.add(node);
//    }
//
//    public int[] findOrder(int courses, int[][] prerequisites) {
//
//        init(courses);
//
//        for (int[] prerequisite : prerequisites) {
//            int dest = prerequisite[0];
//            int src = prerequisite[1];
//            List<Integer> list = tempList.getOrDefault(src, new ArrayList<>());
//            list.add(dest);
//            tempList.put(src, list);
//        }
//
//        for (int i = 0; i < courses; i++) {
//            if (number.get(i) == ONE) {
//                dfs(i);
//            }
//        }
//
//        int[] order;
//        if (check) {
//            order = new int[courses];
//            for (int i = 0; i < courses; i++) {
//                order[i] = courseOrder.get(courses - i - 1);
//            }
//        } else {
//            order = new int[0];
//        }
//
//        return order;
//    }
//
//    public static void main(String[] args) {
//        int[][] matrix3 = {
//                {1, 0},
//                {2, 0}
//        };
//
//        int[][] matrix4 = {
//                {1, 0},
//                {2, 1}
//        };
//
//        for (int[] array : matrix4) {
//            System.out.println(Arrays.toString(array));
//        }
//
//        int num = 3;
//
//        System.out.println("num=" + 3);
//        Solution solution = new Solution();
//        int[] order = solution.findOrder(num, matrix3);
//        for (int i = 0; i < order.length; i++) {
//            if (i != order.length - 1){
//                System.out.print(order[i] + "->");
//            }else {
//                System.out.print(order[i]);
//            }
//        }
//    }
//}
