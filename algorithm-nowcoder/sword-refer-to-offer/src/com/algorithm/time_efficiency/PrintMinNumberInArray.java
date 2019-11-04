package com.algorithm.time_efficiency;

/**
 * @Author 李非凡
 * @Description:
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @Date 2019/11/3 15:48
 * @Version 1.0
 */
public class PrintMinNumberInArray {

    /**
     * 打印数组排成最小的数
     * @param numbers 数组
     * @return 数组排成的最小的数
     */
    private String PrintMinNumber(int[] numbers) {
        int length = numbers.length;
        if (length == 0)
            return "";

        StringBuilder builder = new StringBuilder();



        return null;
    }

    public static void main(String[] args) {
        int[] array = {3, 32, 321};
        PrintMinNumberInArray print = new PrintMinNumberInArray();
        System.out.println(print.PrintMinNumber(array));
    }
}
