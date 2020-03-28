package com.atguigu.algorithm.search;

/**
 * @Author 李非凡
 * @Description: 二分查找（非递归/循环实现）
 *
 * @Date 2020/3/12 0:48
 * @Version 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        // 测试
        int[] array = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(array, 8);
        System.out.println("index=" + index);
    }

    /**
     * 二分查找非递归实现
     * @param array 待查找的数组，array是升序排序的数组
     * @param findValue 需要查找的数
     * @return 找到返回对应下标，-1表示没有找到
     */
    private static int binarySearch(int[] array, int findValue) {
        // 左边
        int left = 0;
        // 右边
        int right = array.length - 1;
        // 说明可以继续查找
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == findValue) {
                return middle;
            }else if (array[middle] > findValue) {
                // 向左查找
                right = middle - 1;
            }else {
                // 向右查找
                left = middle + 1;
            }
        }
        return -1;
    }
}
