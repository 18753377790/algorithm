package com.algorithm.offer.knowledgetransferability;

/**
 * @Author 李非凡
 * @Description: 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @Date 2019/11/2 17:57
 * @Version 1.0
 */
public class FindNumsAppearOnceInArray {

    public static void main(String[] args) {

        int[] array = {1, 3, 1, 4};
        int[] num1 = new int[1];
        int[] num2 = new int[2];

        new FindNumsAppearOnceInArray().findNumsAppearOnce(array, num1, num2);

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * @param array
     * @param num1
     * @param num2
     */
    private void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array.length < 2) {
            return;
        }

        if (array.length == 2 && array[0] != array[1]) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        num1[0] = Integer.MAX_VALUE;
        num2[0] = Integer.MAX_VALUE;

        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                // 如果两个数相等且两个数的下标不相等
                if (array[i] == array[j] && i != j) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                flag = false;
            }else {
                if (num1[0] == Integer.MAX_VALUE) {
                    num1[0] = array[i];
                }else {
                    num2[0] = array[i];
                }
            }
        }

    }
}
