package com.algorithm.offer.knowledgetransferability;

import java.util.ArrayList;

/**
 * @Author 李非凡
 * @Description:
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @Date 2019/11/2 18:30
 * @Version 1.0
 */
public class FindNumbersWithSumInArray {

    /**
     * 寻找和为S的两个数字
     * 1.两个数和为S
     * 2.两个数乘积是和为S中的数最小的
     * 3.输出两个数时小的先输出
     * @param array 递增排序的数组
     * @param sum 求和的数S
     * @return 存两个数的List
     */
    private ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array.length == 0)
            return null;

        // 较小数
        int num1 = 0;
        // 较大数
        int num2 = 0;
        // 两数乘积
        int product = 0;


        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == sum){
                    product = array[i] * array[j];
                    if (array[i] < array[j]){
                        num1 = array[i];
                        num2 = array[j];
                    }else {
                        num1 = array[j];
                        num2 = array[i];
                    }
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        return list;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 10;
        FindNumbersWithSumInArray find = new FindNumbersWithSumInArray();
        System.out.println(find.FindNumbersWithSum(array, sum));
    }
}
