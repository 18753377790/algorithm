package com.algorithm.search;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 顺序查找
 * 主要针对少量的，无规则的数据
 * @Date 2018/10/16 21:27
 * @Version 1.0
 */
public class SequentialSearch {

    /**
     * 数组长度
     */
    private static final int LENGTH = 10;

    /**
     * 顺序查找
     * @param array 待查找的数组
     * @param n 数组的长度
     * @param x 要查找的数
     * @return -1为未找到，其他为与x相等的数在待查找的数组的下标
     */
    private static int sequentialSearch(int[] array, int n, int x) {
        int flag = -1;
        for (int i = 0; i < n; i++) {
            if (x == array[i]) {
                flag = i;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        int[] array = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            array[i] = (int) (Math.random() * (100 + 1));
        }

        Scanner scanner = new Scanner(System.in);
    }
}
