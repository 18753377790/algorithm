package com.atguigu.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author 李非凡
 * @Description: 冒泡排序
 * 冒泡排序规则
 * 1.一共进行数组的length-1次外层循环
 * 2.每一趟排序的次数在逐渐的减少
 * 3.如果我们发现在某趟排序中，没有发生一次交换，可以提前结束冒泡排序，这就是冒泡排序的优化
 *
 * 冒泡排序的演变过程（5个数）
 * 1.第一趟排序，将最大的数排在最后
 * 2.第二趟排序，将第二大的数排在倒数第二位
 * 3.第三趟排序，将第三大的数排在倒数第三位
 * 4.第四趟排序，将第四大的数排在倒数第四位
 * @Date 2020/3/5 11:24
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        // 用于演示的数组
//        int[] array = {3, 9, -1, 10, -2};
//        System.out.println("排序前" );
//        System.out.println(Arrays.toString(array));
//        // 测试冒泡排序
//        bubbleSort(array);
//        // 输出排序后的数组
//        System.out.println("排序后");
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

        // 测试冒泡排序
        bubbleSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    /**
     * 冒泡排序的演变过程
     * @param array
     */
    private static void bubbleSortDemo(int[] array) {

        // 临时变量，用于数据的交换
        int temp;

        // 第一趟排序，将最大的数排在最后
        for (int j = 0; j < array.length - 1; j++) {
            // 如果前面的数比后面的数大，则交换
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组：");
        System.out.println(Arrays.toString(array));

        // 第二趟排序，将第二大的数排在倒数第二位
        for (int j = 0; j < array.length - 1 - 1; j++) {
            // 如果前面的数比后面的数大，则交换
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组：");
        System.out.println(Arrays.toString(array));

        // 第三趟排序，将第三大的数排在倒数第三位
        for (int j = 0; j < array.length - 1 - 2; j++) {
            // 如果前面的数比后面的数大，则交换
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组：");
        System.out.println(Arrays.toString(array));

        // 第四趟排序，将第四大的数排在倒数第四位
        for (int j = 0; j < array.length - 1 - 3; j++) {
            // 如果前面的数比后面的数大，则交换
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 将冒泡排序算法封装成一个方法
     * 冒泡排序的时间复杂度O(n^2)
     * @param array
     */
    private static void bubbleSort(int[] array) {
        // 标识变量，用于优化冒泡排序
        boolean flag = false;
        // 冒泡排序的时间复杂度O(n^2)
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (array[j] > array[j + 1]) {
                    // 发生交换就将flag = true
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
//            System.out.println("第" + (i + 1) + "趟排序后的数组：");
//            System.out.println(Arrays.toString(array));

            // 如果flag == false，说明在一趟排序中一次交换都没有发生
            if (!flag) {
                break;
            }else {
                // 重置flag，进行下次判断
                flag = false;
            }
        }
    }
}
