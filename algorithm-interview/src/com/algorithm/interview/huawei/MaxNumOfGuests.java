package com.algorithm.interview.huawei;

import java.util.*;

/**
 * @Author 李非凡
 * @Description: 最大客人数量
 * 输入
 * 12,15
 * 16,17
 * 12,20
 * -1,-1
 *
 * 输出
 * [12,13):2
 * [13,14):2
 * [14,15):2
 * [15,16):1
 * [16,17):2
 * [17,18):1
 * [18,19):1
 * [19,20):1
 * @Date 2020/3/15 21:11
 * @Version 1.0
 */
public class MaxNumOfGuests {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "";

        List<String> list = new ArrayList<>(10);

        while (true) {
            str = scanner.next();
            if ("-1,-1".trim().equals(str)) {
                break;
            }
            String[] strings = str.trim().split(",");
            int start = Integer.parseInt(strings[0]);
            int end = Integer.parseInt(strings[1]);
            if (start >= end || start < 12 || end > 20) {
                return;
            }
            list.add(str.trim());
        }

        maxNumOfGuests(list);
    }

    private static void maxNumOfGuests(List<String> list) {
        if (list == null || list.size() == 0 || list.size() > 100) {
            return;
        }

        int[] guests = new int[20];

        for (int i = 0; i < list.size(); i++) {
            String[] strings = list.get(i).trim().split(",");
            int start = Integer.parseInt(strings[0]);
            int end = Integer.parseInt(strings[1]);

            for (int j = start; j < end; j++) {
                guests[j] += 1;
            }
        }

        for (int i = 12; i < guests.length; i++) {
            System.out.println("[" + i + "," + (i + 1) + "):" + guests[i]);
        }
    }
}
