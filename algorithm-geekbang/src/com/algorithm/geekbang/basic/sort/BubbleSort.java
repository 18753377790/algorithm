package com.algorithm.geekbang.basic.sort;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 冒泡排序
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否
 * 满足大小关系要求。如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在
 * 的位置，重复 n 次，就完成了 n 个数据的排序工作。
 *
 * 一、排序算法的执行效率
 * 1.时间复杂度
 * 最好 O(n)
 * 对应要排序的原始数据：要排序的数据已经是有序的了
 * 最坏 O(n^2)
 * 对应要排序的原始数据：要排序的数据刚好是倒序排列的
 * 平均 O(n^2)
 * 2.时间复杂度的系数、常数 、低阶
 *
 * 3.比较次数和交换（或移动）次数
 *
 * 二、排序算法的内存消耗
 * 空间复杂度是O(1)，是原地排序
 *
 * 三、排序算法的稳定性
 * 是稳定排序算法
 * @Date 2019/9/30 17:38
 * @Version 1.0
 */
public class BubbleSort {

    /**
     * 冒泡排序，a 表示数组，n 表示数组大小
     * @param a 待排序的数组
     * @param n 数组的长度
     */
    private void bubbleSort(int[] a, int n){
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                // 交换，每次交换需要执行3行代码
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 6, 5};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
