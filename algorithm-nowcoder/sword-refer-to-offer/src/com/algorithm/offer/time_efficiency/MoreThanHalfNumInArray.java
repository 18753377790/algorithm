package com.algorithm.offer.time_efficiency;

/**
 * @Author 李非凡
 * @Description:
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Date 2019/11/3 15:01
 * @Version 1.0
 */
public class MoreThanHalfNumInArray {

    /**
     * 寻找数组中出现次数超过一半的数字
     * @param array 传入的数组
     * @return 数组中出现次数超过一半的数字
     */
    private int MoreThanHalfNum(int[] array) {
        if (array.length == 0)
            return 0;
        // 数组中出现次数超过一半的数字，默认为0
        int number = 0;

        for (int i = 0; i < array.length; i++) {
            // 统计数字出现的次数，每次统计都清零
            int count = 0;
            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j])
                    count++;
            }
            if (count > array.length / 2)
                number = array[i];
        }
        return number;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        int[] arr = {1,2,3,2,4,2,5,2,3};
        MoreThanHalfNumInArray halfNum = new MoreThanHalfNumInArray();
        System.out.println(halfNum.MoreThanHalfNum(array));
        System.out.println(halfNum.MoreThanHalfNum(arr));
    }
}
