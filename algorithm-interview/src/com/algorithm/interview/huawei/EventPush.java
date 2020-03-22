package com.algorithm.interview.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 事件推送
 * Ai <= Bj
 * 输入
 * A={1,3,5},B={2,4,6},R=1
 * 输出
 * (1,2)(3,4)(5,6)
 * @Date 2020/3/15 21:16
 * @Version 1.0
 */
public class EventPush {

    public static void main(String[] args) {
//        int[] a = {1, 3, 5};
//        int[] b = {2, 4, 6};
//        int r = 1;

        int[] a = new int[50];
        int[] b = new int[50];

        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();

        for (int i = 0; i < a.length; i++) {
//            a[i] =
        }

        for (int i = 0; i < a.length; i++) {

        }

        eventPush(a, b, r);
    }

    private static void eventPush(int[] a, int[] b, int r) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {
                if (a[i] <= b[j] && b[j] - a[i] <= r) {
                    map.put(a[i], b[j]);
                    break;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }
    }
}
