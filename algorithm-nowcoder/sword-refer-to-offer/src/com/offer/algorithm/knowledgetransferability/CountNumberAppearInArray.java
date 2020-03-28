package com.offer.algorithm.knowledgetransferability;

/**
 * @Author 李非凡
 * @Description:
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 * @Date 2019/11/2 18:03
 * @Version 1.0
 */
public class CountNumberAppearInArray {

    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param array 排序数组
     * @param k 要找的数字
     * @return 数字出现的次数
     */
    private int GetNumberOfK(int [] array , int k) {
        if (array.length == 0)
            return 0;
        int count = 0;
        for (int value : array) {
            if (value == k)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 4, 4, 5, 6, 7};
        int k = 4;
        CountNumberAppearInArray count = new CountNumberAppearInArray();
        System.out.println(count.GetNumberOfK(array, k));
    }
}
