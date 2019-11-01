package com.algorithm.lb.sort;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 归并排序
 * 原理：分割利用满二叉树的结构，然后合并排序
 * @Date 2019/9/16 20:55
 * @Version 1.0
 */
public class MergeSort {

    /**
     * 归并排序
     * @param data 待排序的数组
     * @param left 左边第一个数的位置
     * @param right 右边第一个数的位置
     */
    private static void mergeSort(int[] data, int left, int right){
        // 当左边的数小于右边的数时
        if (left < right){
            // 分割过程
            int middle = (left + right) / 2;
            // 分割左边
            mergeSort(data, left, middle);
            // 分割右边
            mergeSort(data, middle + 1, right);
            // 合并过程
            merge(data, left, middle, right);
        }
    }

    /**
     * 合并过程
     * @param data 待排序的数组
     * @param left 左边第一个数的位置
     * @param middle 中间数的位置
     * @param right 右边第一个数的位置
     */
    private static void merge(int[] data, int left, int middle, int right){
        // 用来保存合并后的序列，辅助我们排序
        int[] temp = new int[data.length];
        // 表示左边的第一个数的位置
        int pointLeft = left;
        // 表示右边的第一个数的位置
        int pointRight = middle + 1;
        // 用来保存当前填了那个数字到temp里面去
        int location = left;

        while (pointLeft <= middle && pointRight <= right){
            if (data[pointLeft] <= data[pointRight]){
                temp[location] = data[pointLeft];
                location++;
                pointLeft++;
            }else {
                temp[location] = data[pointRight];
                location++;
                pointRight++;
            }
        }

        while (pointLeft <= middle){
            temp[location++] = data[pointLeft++];
        }

        while (pointRight <= right){
            temp[location++] = data[pointRight++];
        }
        // 将辅助数组存入原数组里
//        for(int i = left ;i <= right ; i++) {
//            data[i] = temp[i];
//        }
        if (right + 1 - left >= 0) System.arraycopy(temp, left, data, left, right + 1 - left);
    }

    public static void main(String[] args) {
        int[] data = {9,5,6,8,0,3,7,1,20,1};
        mergeSort(data, 0, data.length -1);
        System.out.println(Arrays.toString(data));
    }
}
