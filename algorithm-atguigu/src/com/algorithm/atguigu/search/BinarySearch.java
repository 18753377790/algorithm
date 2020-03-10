package com.algorithm.atguigu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 李非凡
 * @Description: 二分（折半）查找
 * 充分必要条件：数据在一个有序数组里，即使用二分查找的前提是该数组是有序的
 *
 * 二分查找的思路分析：
 * 1.首先确定数组的中间下标middle = (left+right) / 2
 * 2.然后让待查找的数findValue和array[middle]比较
 *   2.1 findValue > array[middle]，说明在右边，向右递归查找
 *   2.2 findValue < array[middle]，说明在左边，向左递归查找
 *   2.3 findValue = array[middle]，说明找到
 *
 * 递归实现的终止条件
 * 1.找到就结束递归
 * 2.查找完整个数组，仍然没有找到，也要结束递归，即left > right
 * @Date 2020/3/6 11:27
 * @Version 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        // 升级版数组，原始测试数据为{1, 8, 10, 89, 1000, 1234}
        int[] array = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};

        int resultIndex = binarySearch(array, 0, array.length - 1, 1000);
        System.out.println("resultIndex=" + resultIndex);

        List<Integer> resultIndexList = binarySearchPlus(array, 0, array.length - 1, 1000);
        System.out.println("resultIndexList=" + resultIndexList);
    }

    /**
     * 二分查找
     * @param array 待查找的数组，必须是有序的
     * @param left 左索引
     * @param right 右索引
     * @param findValue 要查找的值
     * @return 如果找到就返回对应的数组下标，如果没有找到就返回-1
     */
    private static int binarySearch(int[] array, int left, int right, int findValue) {
        // 当left > right时，说明递归了整个数组但是没有找到（递归的终止条件）
        if (left > right) {
            return -1;
        }
        // 中间的下标
        int middle = (left + right) / 2;
        // 数组的中间值
        int middleValue = array[middle];

        if (findValue > middleValue) {
            // 向右递归
            return binarySearch(array, middle + 1, right, findValue);
        }else if (findValue < middleValue) {
            // 向左递归
            return binarySearch(array, left, middle - 1, findValue);
        }else {
            return middle;
        }
    }

    /**
     * 二分查找
     * 思考题：当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到
     * 例如{1, 8, 10, 89, 1000, 1000, 1234}这个数组中的1000
     *
     * 思路分析：
     * 1.找到middle索引值，不要马上返回
     * 2.向middle索引值的左边扫描，将所有满足1000的元素的下标加入到集合List
     * 3.向middle索引值的右边扫描，将所有满足1000的元素的下标加入到集合List
     * 4.将List返回
     * @param array 待查找的数组，必须是有序的
     * @param left 左索引
     * @param right 右索引
     * @param findValue 要查找的值
     * @return 如果找到就返回List
     */
    private static List<Integer> binarySearchPlus(int[] array, int left, int right, int findValue) {
        // 当left > right时，说明递归了整个数组但是没有找到（递归的终止条件）
        if (left > right) {
            return new ArrayList<>();
        }
        // 中间的下标
        int middle = (left + right) / 2;
        // 数组的中间值
        int middleValue = array[middle];

        if (findValue > middleValue) {
            // 向右递归
            return binarySearchPlus(array, middle + 1, right, findValue);
        }else if (findValue < middleValue) {
            // 向左递归
            return binarySearchPlus(array, left, middle - 1, findValue);
        }else {
            List<Integer> list = new ArrayList<>();

            // 向middle索引值的左边扫描，将所有满足1000的元素的下标加入到集合List
            int temp = middle - 1;
            /*
             temp < 0已经到最左边
             相当于在循环内加了if (temp < 0 || array[temp] != findValue) break
             */
            while (temp >= 0 && array[temp] == findValue) {
                // 否则就把temp放入到集合中
                list.add(temp);
                // temp左移
                temp -= 1;
            }

            list.add(middle);

            // 向middle索引值的右边扫描，将所有满足1000的元素的下标加入到集合List
            temp = middle + 1;
            /*
             temp > array.length - 1已经到最右边
             相当于在循环内加了if (temp > array.length - 1 || array[temp] != findValue) break
             */
            while (temp <= array.length - 1 && array[temp] == findValue) {
                // 否则就把temp放入到集合中
                list.add(temp);
                // temp右移
                temp += 1;
            }

            return list;
        }
    }
}
