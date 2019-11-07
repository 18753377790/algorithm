package com.algorithm.offer.stack_and_queue;

import java.util.ArrayList;

/**
 * @Author 李非凡
 * @Description:
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * @Date 2019/11/4 20:47
 * @Version 1.0
 */
public class MaxInWindows {

    /**
     * 求滑动窗口最大值
     * @param num 给定数组
     * @param size 滑动窗口大小
     * @return 滑动窗口最大值的序列
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        int length = num.length;
        if (length == 0 || size < 0)
            return null;


        return null;
    }

    public static void main(String[] args) {

    }
}
