package com.algorithm.interview.oppo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Author 李非凡
 * @Description:
 * OPPO面试题：两个数组求交集
 * @Date 2019/11/20 14:04
 * @Version 1.0
 */
public class ArrayIntersection {

    /**
     * 双层循环实现数组求交集（时间复杂度高，大量数据下不建议使用）
     * @param array1 数组1
     * @param array2 数组2
     * @return 两个数组的交集
     */
    private static int[] getIntersectionByLoop(int[] array1, int[] array2) {
//        int[] result = new int[100];

//        for (int i = 0; i < array1.length; i++) {
//            for (int j = 0; j < array2.length; j++) {
//                if (array1[i] == array2[j])
//                    result[] = ;
//            }
//        }

        return null;
    }

    /**
     * HashSet实现数组求交集
     * 利用HashSet不可重复性（HashMap的key值不能重复）对数组进行去重
     * @param array1 数组1
     * @param array2 数组2
     * @return 两个数组的交集
     */
    private static int[] getIntersectionByHashSet(int[] array1, int[] array2) {
        // 将int数组转换成Integer数组
        Integer[] integers1 = Arrays.stream(array1).boxed().toArray(Integer[]::new);
        Integer[] integers2 = Arrays.stream(array2).boxed().toArray(Integer[]::new);

        Set<Integer> set1 = new HashSet<>(Arrays.asList(integers1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(integers2));
        set1.retainAll(set2);

//        Integer[] integers = set1.toArray(new Integer[set1.size()]);
        Integer[] integers = set1.toArray(new Integer[0]);
        return Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 流和过滤器实现数组求交集
     * @param array1 数组1
     * @param array2 数组2
     * @return 两个数组的交集
     */
    private static int[] getIntersectionByStream(int[] array1, int[] array2) {
        return Arrays.stream(array1)
                .distinct()
                .filter(x -> Arrays.stream(array2).anyMatch(y -> y == x))
                .toArray();
    }

    public static void main(String[] args) {
        int[] array1 = new Random().ints(100, 1, 10000).toArray();
        int[] array2 = new Random().ints(100, 1, 10000).toArray();

        System.out.println("" + Arrays.toString(array1));
        System.out.println("" + Arrays.toString(array2));
        System.out.println("双层循环实现数组求交集：" + Arrays.toString(getIntersectionByLoop(array1, array2)));
        System.out.println("HashSet实现数组求交集：" + Arrays.toString(getIntersectionByHashSet(array1, array2)) + getIntersectionByHashSet(array1, array2).length);
        System.out.println("流和过滤器实现数组求交集：" + Arrays.toString(getIntersectionByStream(array1, array2)) + getIntersectionByStream(array1, array2).length);
    }
}
