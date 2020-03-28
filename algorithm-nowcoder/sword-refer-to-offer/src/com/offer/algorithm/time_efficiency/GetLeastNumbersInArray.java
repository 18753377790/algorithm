package com.offer.algorithm.time_efficiency;

import java.util.ArrayList;

/**
 * @Author 李非凡
 * @Description:
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @Date 2019/11/2 21:41
 * @Version 1.0
 */
public class GetLeastNumbersInArray {

    /**
     * 寻找最小的K个数
     * @param input 待寻找的数组
     * @param k 最小的k个
     * @return 最小的k个数
     */
    private ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k == 0)
            return new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < input.length - i - 1; j++) {
                // 交换，每次交换需要执行3行代码
                if (input[j] > input[j + 1]){
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag)
                break;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        int k = 4;
        GetLeastNumbersInArray getLeast = new GetLeastNumbersInArray();
        System.out.println(getLeast.GetLeastNumbers(array, k));
    }
}
