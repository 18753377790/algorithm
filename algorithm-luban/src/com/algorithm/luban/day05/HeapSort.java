package com.algorithm.luban.day05;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 堆排序
 * 使用数组表示二叉树，并实现堆排序
 *
 * 一、实现堆排序要先——建最大堆
 * 儿子中比出最大的儿子
 * 最大的儿子与父亲比较
 * 若儿子比父亲大，则与父亲交换
 * 注意：从下往上比，从右往左比，一层层往上比
 *
 * 1.有多少个父节点？  父节点个数 = (arr.Len - 1)/2（这里是int类型的值，没有小数和余数）
 * 2.每个父节点的索引是多少?   父节点索引范围：1~父节点个数
 * 3.子节点索引是多少?  左儿子 = 父节点索引*2  右儿子 = 左儿子 + 1
 *
 * 二、根节点的数据与最后一个节点的数据进行交换
 * @Date 2019/4/14 1:53
 * @Version 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        //从数组的第一个（索引为1的）元素开始（因为要把索引为0的数据排除掉，所以4为根节点），从上往下，从左往右
        int[] ints = {0,6,2,8,1,5,4,9,3};
        //实现堆排序

        //标记最后一个数的索引（默认是最后一个数）
        int end = ints.length;
        //当数组长度为2时，二叉树里面还有1个数，此时停止循环
        while (end > 2){
        /*
        第一个节点（根节点）是数组的第二个元素
        父节点个数 = (数组长度-1)/2
        父节点索引 = 1 ~ 父节点个数
        循环遍历所有的父节点（从最后一个父节点开始遍历）
         */
            for (int i = (end - 1)/2; i >= 1; i--) {
            /*
            左儿子索引 = 父节点索引*2
            右儿子索引 = 左儿子索引 + 1
            根据父节点索引计算两个儿子的索引，找到两个儿子中最大的儿子
             */
                int maxIndex = i*2;//默认左儿子最大（因为会出现只有左儿子，没有右儿子的情况）
                //当存在右儿子且右儿子比左儿子大时
                if ((maxIndex + 1) < end && ints[maxIndex + 1] > ints[maxIndex]){
                    //设置最大的儿子是右儿子
                    maxIndex++;
                }
                //让最大的儿子与父亲比，比父亲大则交换
                if (ints[maxIndex] > ints[i]){
                    int temp = ints[maxIndex];
                    ints[maxIndex] = ints[i];
                    ints[i] = temp;
                }
            }

            //根节点的数据与最后一个节点的数据进行交换（）
            int data = ints[1];
            ints[1] = ints[end - 1];
            ints[end - 1] = data;

            //每循环一次，最后一个数的位置向前移动一位
            end--;
        }

        System.out.println(Arrays.toString(ints));
    }
}
