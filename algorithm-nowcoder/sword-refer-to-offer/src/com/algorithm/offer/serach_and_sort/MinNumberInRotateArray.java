package com.algorithm.offer.serach_and_sort;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description: 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Date 2020/3/15 10:40
 * @Version 1.0
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
    }

    /**
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length <= 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = array[j];
                }
            }
        }
        return array[0];
    }
}
