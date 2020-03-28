package com.atguigu.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author 李非凡
 * @Description: 快速排序
 * 快速排序是对冒泡排序的一种改进
 * 整个排序过程可以递归进行
 * @Date 2020/3/5 17:30
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] array = {-9, 78, 0, 23, -567, 70};
//        quickSort(array, 0, array.length - 1);
//        System.out.println("array=" + Arrays.toString(array));

        // 创建一个8000000个数的随机数组
        int[] array = new int[8000000];
        for (int i = 0; i < array.length; i++) {
            // 生成一个[0,8000000)数
            array[i] = new Random().nextInt(8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date1 = new Date();
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + date1Str);

        // 测试快速排序
        quickSort(array, 0, array.length - 1);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    /**
     * 快速排序
     * @param array 待排序的数组
     * @param left 左索引，初始为0
     * @param right 右索引，初始为数组length-1
     */
    private static void quickSort(int[] array, int left, int right) {
        // 左下标
        int start = left;
        // 右下标
        int end = right;
        // 中心点
        int pivot = array[(left + right) / 2];
        // 临时变量用于交换
        int temp;

        /*
         while循环的目的是让比pivot值小的放到pivot左边
         让比pivot值大的放到pivot右边
         所以当左下标和右下标重合时，循环退出
         */
        while (start < end) {
            // 在pivot的左边一直找，找到一个大于等于pivot才退出
            while (array[start] < pivot) {
                start += 1;
            }
            // 在pivot的右边一直找，找到一个小于等于pivot才退出
            while (array[end] > pivot) {
                end -= 1;
            }
            /*
             如果start >= end成立，说明pivot的左右两边的值，已经是
             左边全部是小于等于pivot的值
             右边全部是大于等于pivot的值
             */
            if (start >= end) {
                break;
            }
            // 交换
            temp = array[end];
            array[end] = array[start];
            array[start] = temp;

            // 如果交换完后，发现array[start]与pivot值相等则end--，前移
            if (array[start] == pivot) {
                end -= 1;
            }
            // 如果交换完后，发现array[end]与pivot值相等则start++，后移
            if (array[end] == pivot) {
                start += 1;
            }
        }

        // 如果start==end，必须start++，end--
        if (start == end) {
            start += 1;
            end -= 1;
        }

        // 向左递归
        if (left < start) {
            quickSort(array, left, end);
        }
        // 向右递归
        if (right > end) {
            quickSort(array, start, right);
        }
    }
}
