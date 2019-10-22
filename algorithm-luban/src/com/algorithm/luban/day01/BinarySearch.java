package com.algorithm.luban.day01;

/**
 * @Author 李非凡
 * @Description:
 * 二分查找
 * 二分查找只适合有序的数据
 * 所以要先对数据进行快速排序然后再查找
 * 二分查找法是比较简单的查找法，效率更高的查找法是红黑二叉树
 * 开始位置start
 * 结束位置end
 * 中间位置medium
 * 第一次比较m = (s+e)/2
 * 如果小于e = m-1
 * 如果大于s = m+1
 * 当s>e时，此数不存在
 * @Date 2019/4/7 0:37
 * @Version 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        //
        int[] ints = {2,4};
        //开始位置
        int s = 0;
        //结束位置
        int e = ints.length - 1;
        //中间位置
        int m = 0;

        int num = 4;

        while (s <= e){
            //
            m = (s + e)/2;
            //
            if (num == ints[m]){//
                System.out.println("");
                return;
            }else if (num < ints[m]){
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        System.out.println();
    }
}
