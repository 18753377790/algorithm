package com.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author 李非凡
 * @Description: 选择排序
 * 算法：先简单，再复杂，就是可以把一个复杂的算法拆分成简单的问题，然后再逐步解决
 *
 * 选择排序说明：
 * 1.选择排序一共有数组大小-1轮
 * 2.每一轮排序又是一个循环，循环的规则：
 *   2.1先假定当前这个数是最小数
 *   2.2用当前数和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
 *   2.3当遍历到数组的最后时，就得到本轮最小数和下标
 *   2.4交换
 * @Date 2020/3/5 17:49
 * @Version 1.0
 */
public class SelectSort {

    public static void main(String[] args) {
//        int[] array = {101, 34, 119, 1};
//        System.out.println("排序前的数组：");
//        System.out.println(Arrays.toString(array));
//        selectSort(array);
//        System.out.println("排序后的数组：");
//        System.out.println(Arrays.toString(array));

        // 创建一个80000个数的随机数组
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            // 生成一个[0,8000000)数
            array[i] = new Random().nextInt(8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date1 = new Date();
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + date1Str);

        // 测试选择排序
        selectSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    /**
     * 选择排序演示
     * 使用逐步推导的方式来演示选择排序
     * 原始的数组：101,34,119,1
     * @param array
     */
    private static void selectSortDemo(int[] array) {

        // 第一轮
        int index = 0;
        int min = array[0];

        for (int i = 0 + 1; i < array.length; i++) {
            // 说明假定的最小值并不是最小的
            if (min > array[i]) {
                // 重置min
                min = array[i];
                // 重置index
                index = i;
            }
        }

        if (index != 0) {
            // 将最小值放在array[0]的位置，即交换位置
            array[index] = array[0];
            array[0] = min;
        }

        System.out.println("第一轮后的数组：");
        // 1,34,119,101
        System.out.println(Arrays.toString(array));

        // 第二轮
        index = 1;
        min = array[1];

        for (int i = 1 + 1; i < array.length; i++) {
            // 说明假定的最小值并不是最小的
            if (min > array[i]) {
                // 重置min
                min = array[i];
                // 重置index
                index = i;
            }
        }

        if (index != 1) {
            // 将最小值放在array[1]的位置，即交换位置
            array[index] = array[1];
            array[1] = min;
        }

        System.out.println("第二轮后的数组：");
        // 1,34,119,101
        System.out.println(Arrays.toString(array));

        // 第三轮
        index = 2;
        min = array[2];

        for (int i = 2 + 1; i < array.length; i++) {
            // 说明假定的最小值并不是最小的
            if (min > array[i]) {
                // 重置min
                min = array[i];
                // 重置index
                index = i;
            }
        }

        if (index != 2) {
            // 将最小值放在array[2]的位置，即交换位置
            array[index] = array[2];
            array[2] = min;
        }

        System.out.println("第三轮后的数组：");
        // 1,34,101,119
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     * 选择排序的时间复杂度O(n^2)
     * @param array
     */
    private static void selectSort(int[] array) {
        // 在推导的过程中，发现规律，用for循环解决
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            int min = array[i];

            for (int j = i + 1; j < array.length; j++) {
                // 说明假定的最小值并不是最小的
                if (min > array[j]) {
                    // 重置min
                    min = array[j];
                    // 重置index
                    index = j;
                }
            }

            if (index != 0) {
                // 将最小值放在array[i]的位置，即交换位置
                array[index] = array[i];
                array[i] = min;
            }

//            System.out.println("第" + (i + 1) + "轮后的数组：");
//            System.out.println(Arrays.toString(array));
        }
    }
}
