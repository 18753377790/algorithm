package com.algorithm.time_efficiency;

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
     *
     * @param array
     * @return
     */
    private int MoreThanHalfNum(int[] array) {
        if (array.length == 0)
            return 0;

        int count = 0;
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            number = i;

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        MoreThanHalfNumInArray halfNum = new MoreThanHalfNumInArray();
        System.out.println(halfNum.MoreThanHalfNum(array));
    }
}
