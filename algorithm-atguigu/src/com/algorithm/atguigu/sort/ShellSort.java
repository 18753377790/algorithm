package com.algorithm.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author 李非凡
 * @Description: 希尔排序（缩小增量排序）
 * @Date 2020/3/5 11:26
 * @Version 1.0
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSortDemo(array);
//        shellSort(array);

        // 创建一个80000个数的随机数组
        int[] array = new int[8000000];
        for (int i = 0; i < array.length; i++) {
            // 生成一个[0,8000000)数
            array[i] = new Random().nextInt(8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date1 = new Date();
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + date1Str);

        // 测试交换式希尔排序
//        shellSort(array);
        // 测试移位式希尔排序
        shellSort2(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    /**
     * 希尔排序演示
     * 使用逐步推导的方式来编写希尔排序
     * @param array
     */
    private static void shellSortDemo(int[] array) {

        int temp;
        /*
         希尔排序的第一轮排序
         第一轮排序将10个数据分成了5组，即length/2组
         */
        for (int i = 5; i < array.length; i++) {
            // 遍历各组中所有的元素（共有5组，每一组有2个元素），步长是5（length/2）
            for (int j = i - 5; j >= 0; j -= 5) {
                // 如果当前元素大于加上步长后的那个元素，说明需要交换
                if (array[j] > array[j + 5]) {
                    temp = array[j];
                    array[j] = array[j + 5];
                    array[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序第一轮后数组：");
        System.out.println(Arrays.toString(array));

        /*
         希尔排序的第二轮排序
         第二轮排序将10个数据分成了2组，即length/2/2组
         */
        for (int i = 2; i < array.length; i++) {
            // 遍历各组中所有的元素（共有2组，每一组有5个元素），步长是1（length/2/2/2）
            for (int j = i - 2; j >= 0; j -= 2) {
                // 如果当前元素大于加上步长后的那个元素，说明需要交换
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序第三轮后数组：");
        System.out.println(Arrays.toString(array));

        /*
         希尔排序的第三轮排序
         第三轮排序将10个数据分成了1组，即length/2/2/2组
         */
        for (int i = 1; i < array.length; i++) {
            // 遍历各组中所有的元素（共有1组，每一组有10个元素），步长是2（length/2/2）
            for (int j = i - 1; j >= 0; j -= 1) {
                // 如果当前元素大于加上步长后的那个元素，说明需要交换
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序第二轮后数组：");
        System.out.println(Arrays.toString(array));

    }

    /**
     * 交换式希尔排序
     * @param array
     */
    private static void shellSort(int[] array) {
        int temp;
        int count = 0;
        // 根据逐步分析，使用循环处理
        for (int step = array.length / 2; step > 0; step /= 2) {
            /*
             希尔排序的第count轮排序
             第n轮排序将10个数据分成了step组，即length/2组
             */
            for (int i = step; i < array.length; i++) {
                // 遍历各组中所有的元素（共有step组，每一组有length/step个元素），步长是step
                for (int j = i - step; j >= 0; j -= step) {
                    // 如果当前元素大于加上步长后的那个元素，说明需要交换
                    if (array[j] > array[j + step]) {
                        temp = array[j];
                        array[j] = array[j + step];
                        array[j + step] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮后数组：");
//            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 移位式希尔排序
     * 对交换式的希尔排序进行优化
     * @param array
     */
    private static void shellSort2(int[] array) {
        int count = 0;
        // 增量step，并逐步的缩小增量
        for (int step = array.length / 2; step > 0; step /= 2) {
            // 从第step个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = step; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - step]) {
                    while (j - step >= 0 && temp < array[j - step]) {
                        // 移动
                        array[j] = array[j - step];
                        j -= step;
                    }
                    // 当退出while循环时，就找到了temp的插入位置
                    array[j] = temp;
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮后数组：");
//            System.out.println(Arrays.toString(array));
        }
    }
}
