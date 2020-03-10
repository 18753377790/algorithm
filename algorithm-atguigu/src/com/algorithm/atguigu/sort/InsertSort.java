package com.algorithm.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author 李非凡
 * @Description: 插入排序
 * 插入排序属于内部排序，是对欲排序的元素以插入的方式找寻该元素的适当位置，已达到排序的目的
 * @Date 2020/3/5 21:03
 * @Version 1.0
 */
public class InsertSort {

    public static void main(String[] args) {
//        int[] array = {101, 34, 119, 1};
//        System.out.println("排序前的数组：");
//        System.out.println(Arrays.toString(array));
//        insertSort(array);
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

        // 测试插入排序
        insertSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    /**
     * 插入排序演示
     * 使用逐步推导的方式来讲解插入排序
     * @param array
     */
    private static void insertSortDemo(int[] array) {

        /*
         第一轮 {101, 34, 119, 1}=>{34, 101, 119, 1}
         定义待插入的数
         */
        int insertValue = array[1];
        // 待插入数的索引，相当于1-1，即array[1]前面这个数的下标
        int insertIndex = 0;
        /*
         给insertValue找到插入的位置
         说明：
         1.insertIndex >= 0保证在给insertValue找插入位置，不越界
         2.insertValue < array[insertIndex]待插入的数还没有找到插入位置
         3.将array[insertIndex]后移
         */
        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        // 当退出while循环时，说明插入的位置找到，insertIndex + 1
        array[insertIndex + 1] = insertValue;

        System.out.println("第一轮插入后的数组：");
        // 34, 101, 119, 1
        System.out.println(Arrays.toString(array));

        /*
         第二轮 {34, 101, 119, 1}=>{34, 101, 119, 1}
         定义待插入的数
         */
        insertValue = array[2];
        // 待插入数的索引，相当于2-1，即array[2]前面这个数的下标
        insertIndex = 1;
        /*
         给insertValue找到插入的位置
         说明：
         1.insertIndex >= 0保证在给insertValue找插入位置，不越界
         2.insertValue < array[insertIndex]待插入的数还没有找到插入位置
         3.将array[insertIndex]后移
         */
        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        // 当退出while循环时，说明插入的位置找到，insertIndex + 1
        array[insertIndex + 1] = insertValue;

        System.out.println("第二轮插入后的数组：");
        // 34, 101, 119, 1
        System.out.println(Arrays.toString(array));

        /*
         第三轮 {34, 101, 119, 1}=>{1, 34, 101, 119}
         定义待插入的数
         */
        insertValue = array[3];
        // 待插入数的索引，相当于3-1，即array[3]前面这个数的下标
        insertIndex = 2;
        /*
         给insertValue找到插入的位置
         说明：
         1.insertIndex >= 0保证在给insertValue找插入位置，不越界
         2.insertValue < array[insertIndex]待插入的数还没有找到插入位置
         3.将array[insertIndex]后移
         */
        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        // 当退出while循环时，说明插入的位置找到，insertIndex + 1
        array[insertIndex + 1] = insertValue;

        System.out.println("第三轮插入后的数组：");
        // 1, 34, 101, 119
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     * @param array
     */
    private static void insertSort(int[] array) {
        //定义待插入的数
        int insertValue;
        // 待插入数的索引，相当于i-1，即array[i]前面这个数的下标
        int insertIndex;
        // 使用for循环将代码简化
        for (int i = 1; i < array.length; i++) {
            insertValue = array[i];
            insertIndex = i - 1;
            /*
             给insertValue找到插入的位置
             说明：
             1.insertIndex >= 0保证在给insertValue找插入位置，不越界
             2.insertValue < array[insertIndex]待插入的数还没有找到插入位置
             3.将array[insertIndex]后移
             */
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            /*
             当退出while循环时，说明插入的位置找到，insertIndex + 1
             判断是否需要赋值
             */
            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertValue;
            }

//            System.out.println("第" + i + "轮插入后的数组：");
//            System.out.println(Arrays.toString(array));
        }
    }
}
