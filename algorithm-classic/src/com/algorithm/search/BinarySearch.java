package com.algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 二分（折半）查找
 * @Date 2018/10/16 21:25
 * @Version 1.0
 */
public class BinarySearch {

    /**
     * 数组长度
     */
    private static final int LENGTH = 10;

    /**
     * 二分（折半）查找
     * @param array 待查找的数组
     * @param x 要查找的数
     * @return -1为未找到，其他为与x相等的数在待查找的数组的下标
     */
    private static int binarySearch(int[] array, int x) {
        // 起始下标
        int low = 0;
        // 终止下标
        int high = LENGTH - 1;
        // 中间值
        int middle;

        while (low <= high) {
            // 每次循环都需要重新计算中间值
            middle = (low + high) / 2;
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

        for (int i = 0; i < LENGTH; i++) {
            array[i] = (int) (100 + Math.random() * (100 + 1));
        }

        System.out.println("二分查找算法演示！");
        System.out.println("排序前数据序列：" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("排序后数据序列：" + Arrays.toString(array));
        System.out.println("输入要查找的数：");

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int n = binarySearch(array, x);

        if (n < 0)
            System.out.println("没找到数据：" + x);
        else
            System.out.println("数据：" + x + "位于数组的第" + (n + 1) + "个元素处。");
    }
}
