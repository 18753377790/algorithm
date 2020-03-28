package com.atguigu.datastructure.search;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description: 插值查找
 * 充分必要条件：有序数组
 *
 * 插值查找原理：
 * 1.插值查找算法类似于二分查找，不同的是插值查找每次从自适应middle处开始查找
 * 2.将折半查找中的求middle索引的公式，low表示左边索引left，high表示右边索引right，key表示要查找的值
 *   middle = (low + high) / 2 = low + (high - low) * (1 / 2)
 *   改成
 *   middle = low + (high - low) * (key - a[low]) / (a[high] - a[low]) 此公式为自适应计算
 * 3.int middle = left + (right - left) * (findValue - array[left]) / (array[right] - array[left])
 *
 * 插值查找适用场景
 * 1.数据量比较大
 * 2.关键字分布比较均匀（数据跳跃性很大）
 * 如果关键字分布不均匀的情况下，该方法不一定比折半查找快
 * @Date 2020/3/7 2:18
 * @Version 1.0
 */
public class InterpolationSearch {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));

//        int[] array = {1, 8, 10, 89, 1000, 1000, 1234};

        int index = interpolationSearch(array, 0, array.length - 1, 1234);
        System.out.println("index=" + index);
    }

    /**
     * 插值查找
     * 插值查找也是需要数组有序
     * @param array 待查找的数组，必须是有序的，这里的数组是升序的
     * @param left 左索引
     * @param right 右索引
     * @param findValue 要查找的值
     * @return 如果找到就返回对应的数组下标，如果没有找到就返回-1
     */
    private static int interpolationSearch(int[] array, int left, int right, int findValue) {
        System.out.println("插值查找被调用");
        /*
         当left > right时，说明递归了整个数组但是没有找到（递归的终止条件）
         由于数组是有序（升序）的，所以findValue < array[0]或者findValue > array[array.length - 1]时，超出数组的范围
         注意：findValue < array[0]和findValue > array[array.length - 1]是必须的，否则得到的middle可能越界
         因为findValue参与了middle的计算，如果findValue特别大，会导致middle特别大
         */
        if (left > right || findValue < array[0] || findValue > array[array.length - 1]) {
            return -1;
        }

        // 根据公式求出数组的中间下标
        int middle = left + (right - left) * (findValue - array[left]) / (array[right] - array[left]);

        // 数组的中间值
        int middleValue = array[middle];

        if (findValue > middleValue) {
            // 向右递归
            return interpolationSearch(array, middle + 1, right, findValue);
        }else if (findValue < middleValue) {
            // 向左递归
            return interpolationSearch(array, left, middle - 1, findValue);
        }else {
            return middle;
        }
    }
}
