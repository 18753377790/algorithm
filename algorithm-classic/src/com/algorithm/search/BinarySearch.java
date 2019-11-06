package com.algorithm.search;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 二分查找
 * @Date 2018/10/16 21:25
 * @Version 1.0
 */
public class BinarySearch {

    /**
     * 数组长度
     */
    private static final int LENGTH = 10;

    /**
     * 二分查找
     * @param array
     * @param n
     * @param x
     * @return
     */
    private static int binarySearch(int[] array, int n, int x) {
        int low = 0;
        int high = n - 1;
        int middle = (low + high) / 2;

        while (low <= high) {
            if (array[middle] == x)
                return middle;
            else if (array[middle] > x)
                high = middle - 1;
            else
                low = middle + 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] array = new int[LENGTH];

        Scanner scanner = new Scanner(System.in);


    }
}
