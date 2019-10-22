package com.algorithm.search;

/**
 * @Author 李非凡
 * @Description:
 * 二分查找
 * @Date 2018/10/16 21:25
 * @Version 1.0
 */
public class BinarySearch {

    /**
     * 快速排序
     * @param array
     * @param left
     * @param right
     */
    private static void quickSort(int[] array, int left, int right) {
        // 开始的位置
        int start = left;
        // 结束的位置
        int end = right;
        // 确定分界值
        int pivot  = array[(left + right) / 2];
        // 当左边小于右边时
        while (left < right){
            //
            while (array[left] < pivot){
                ++left;
            }
            //
            while (array[right] > pivot){
                --right;
            }
            //
            if (left <= right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            //
            if (left == right){
                left++;
            }
            //
            if (left < start){

            }

            if (right< end){

            }
        }
    }

    /**
     * 二分查找
     * @param array
     * @param left
     * @param right
     */
    private static void binarySearch(int[] array, int left, int right) {

    }

    public static void main(String[] args) {

    }
}
