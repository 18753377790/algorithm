package com.algorithm.geekbang.basic.sort;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 插入排序
 * 将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有
 * 一个元素，就是数组的第一个元素。
 * 插入算法的核心思想是取未排序区间中的元素，在已排
 * 序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，
 * 直到未排序区间中元素为空，算法结束。
 *
 * 一、排序算法的执行效率
 * 1.时间复杂度
 * 最好 O(n)
 * 对应要排序的原始数据：要排序的数据已经是有序的了，从尾到头遍历已经有序的数据。
 * 最坏 O(n^2)
 * 对应要排序的原始数据：要排序的数据刚好是倒序排列的
 * 平均 O(n^2)
 * 二、排序算法的内存消耗
 * 空间复杂度是O(1)，是原地排序
 *
 * 三、排序算法的稳定性
 * 是稳定排序算法
 * @Date 2019/9/30 17:38
 * @Version 1.0
 */
public class InsertSort {

    /**
     * 插入排序，a 表示数组，n 表示数组大小
     * @param a 待排序的数组
     * @param n 数组的长度
     */
    private void insertSort(int[] a, int n){
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            // 待定义插入的数
            int value = a[i];
            // 找到待插入数的前一个数的下标
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value){
                    // 数据移动，每次移动需要执行一行代码，所以插入排序比冒泡排序快
                    a[j + 1] = a[j];
                }else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 1, 2, 3};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
