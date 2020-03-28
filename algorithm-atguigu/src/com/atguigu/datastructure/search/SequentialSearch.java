package com.atguigu.datastructure.search;

/**
 * @Author 李非凡
 * @Description: 顺序（线性）查找
 * 线性查找既可以查找有序的数据，也可以查找无序的数据
 * 思考：当数组中待查找的数重复，如何返回多个数据的下标？
 * @Date 2020/3/7 2:10
 * @Version 1.0
 */
public class SequentialSearch {

    public static void main(String[] args) {
        // 无序数组
        int[] array = {1, 9, 11, -1, 34, 89};
        int index = sequentialSearch(array, 11);
        if (index == -1) {
            System.out.println("没有找到" + 11);
        }else {
            System.out.println("已找到，下标为：" + index);
        }
    }

    /**
     * 顺序（线性）查找
     * 这里实现的线性查找是找到一个满足条件的值就返回
     * @param array 待查找的数组
     * @param value 要查找的数
     * @return 数组对应的下标
     */
    private static int sequentialSearch(int[] array, int value) {
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
