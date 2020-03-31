package com.fundamental.algorithm.luban.day04;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 快速排序
 * 快速排序用到了二分法，把数据分成两半
 *
 * 1.让标杆数左边的都比标杆数小，右边的数据都比标杆数大。
 * 快速排序会有2个循环，左边一个和右边一个，左边的循环找比标杆数大的，右边的循环找比标杆数小的，先右后左，左小右大，
 * 选出一个标杆数（一般是第一个数），让其余数据与它比较
 *
 * @Date 2019/4/14 1:44
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] ints = {5,2,8,1,9,4,7,6};

        sort(ints,0,ints.length - 1);

        System.out.println(Arrays.toString(ints));
    }

    /**
     * 返回结果表示标杆数所在的位置，标杆数一般是第一个数
     * @param ints 待排序的数组
     * @param start 开始位置
     * @param end 结束位置
     * @return 中间位置
     */
    private static int sortUnit(int[] ints, int start, int end){
        // 获取标杆数
        int num = ints[start];
        // 记录右边循环的位置
        int s = start;
        // 记录左边循环的位置
        int e = end;
        // 当标杆数左边都是比标杆数小，右边都是比标杆数大的时候，停止循环
        while (s < e){
            // 从右向左的循环（找比标杆值小的数据，扔到左边的循环）
            while (s < e){
                if (ints[e] < num){
                    ints[s] = ints[e];
                    break;
                }
                // 继续向左边移动
                e--;
            }
            // 从左向右的循环（找比标杆值大的数据，扔到右边的循环）
            while (s < e){
                if (ints[s] >= num){
                    ints[e] = ints[s];
                    break;
                }
                // 继续向右边移动
                s++;
            }
        }
        ints[s] = num;
        return s;
    }

    /**
     * 快速排序
     * @param ints 待排序的数组
     * @param start 开始位置
     * @param end 结束位置
     */
    private static void sort(int[] ints, int start, int end){

        if (start < end){
            // 返回中间位置
            int m = sortUnit(ints, start, end);
            // 左边
            sort(ints, start, m - 1);
            // 右边
            sort(ints, m + 1, end);
        }
    }
}
