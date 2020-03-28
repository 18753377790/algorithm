package com.offer.algorithm.time_efficiency;

/**
 * @Author 李非凡
 * @Description:
 * 连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @Date 2019/11/3 15:49
 * @Version 1.0
 */
public class GreatestSumOfSubArray {

    /**
     * 求连续子数组的最大和
     * 注意，数组有可能是只有负数的数组
     * @param array 待求和的数组
     * @return 连续子数组的最大和
     */
    private int FindGreatestSumOfSubArray(int[] array) {
        int length = array.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return array[0];

        // 子数组的和
        int sum = 0;
        // 子数组的最大和
        int max = 0;

        for (int i = 0; i < length; i++) {
            sum += array[i];
        }

        return max;
    }

    public static void main(String[] args) {
        // 8
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        // -1
        int[] arr = {-2,-8,-1,-5,-9};
        GreatestSumOfSubArray greatest = new GreatestSumOfSubArray();
        System.out.println(greatest.FindGreatestSumOfSubArray(array));
        System.out.println(greatest.FindGreatestSumOfSubArray(arr));
    }
}
