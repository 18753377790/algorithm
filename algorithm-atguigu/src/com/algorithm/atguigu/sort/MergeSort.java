package com.algorithm.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author 李非凡
 * @Description: 归并排序
 * 分治算法，递归实现
 * 合并次数为数组length-1次
 * @Date 2020/3/5 17:31
 * @Version 1.0
 */
public class MergeSort {

    public static void main(String[] args) {
        // 8个数据合并7次
//        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};
//        // 归并排序需要一个额外的空间
//        int[] temp = new int[array.length];
//        mergeSort(array, 0, array.length - 1, temp);
//        System.out.println("归并排序后");
//        System.out.println(Arrays.toString(array));

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

        int[] temp = new int[array.length];
        // 测试归并排序
        mergeSort(array, 0, array.length - 1, temp);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    /**
     * 归并排序（分与合的过程）
     * @param array 待排序的数组
     * @param left 左边有序序列的初始索引
     * @param right 右边有序序列的最后索引
     * @param temp 临时中转数组
     */
    private static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            // 中间索引
            int middle = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(array, left, middle, temp);
            // 向右递归进行分解
            mergeSort(array, middle + 1, right, temp);
            // 合并
            merge(array, left, middle, right, temp);
        }
    }

    /**
     * 合并的方法
     * @param array 待排序的数组
     * @param left 左边有序序列的初始索引
     * @param middle 中间索引
     * @param right 右边有序序列的最后索引
     * @param temp 临时中转数组
     */
    private static void merge(int[] array, int left, int middle, int right, int[] temp) {
        // 左边有序序列的初始索引
        int start = left;
        // 右边有序序列的初始索引
        int end = middle + 1;
        // 指向temp数组的当前索引
        int index = 0;

        // 1.先把左右两边（有序）的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
        while (start <= middle && end <= right) {
            /*
             如果左边的有序序列的当前元素小于或等于右边有序序列的当前元素，
             将左边有序序列的当前元素填充到temp数组
             然后后移index和start
             */
            if (array[start] <= array[end]) {
                temp[index] = array[start];
                index += 1;
                start += 1;
            }else {
                // 将右边有序序列的当前元素填充到temp数组
                temp[index] = array[end];
                index += 1;
                end += 1;
            }
        }

        /*
        2.把有剩余数据的一边的数据依次全部填充到temp数组里
        左边的有序序列还有剩余的元素，全部填充到temp中
         */
        while (start <= middle) {
            temp[index] = array[start];
            index += 1;
            start += 1;
        }
        // 左边的有序序列还有剩余的元素，全部填充到temp中
        while (end <= right) {
            temp[index] = array[end];
            index += 1;
            end += 1;
        }
        /*
         3.将temp数组的元素复制到array里面
         注意：并不是每次都复制temp里面所有的数据
         */
        index = 0;
        // 交换的起始下标
        int tempLeft = left;
//        System.out.println("tempLeft=" + tempLeft + "right=" + right);
        /*
        8个元素的数组8, 4, 5, 7, 1, 3, 6, 2
        第一次0,1
        第二次2,3
        第三次0,3
        第四次4,5
        第五次6,7
        第六次4,7
        第七次0,7
         */
        while (tempLeft <= right) {
            array[tempLeft] = temp[index];
            index += 1;
            tempLeft += 1;
        }
    }
}
