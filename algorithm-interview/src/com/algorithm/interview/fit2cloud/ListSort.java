package com.algorithm.interview.fit2cloud;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author 李非凡
 * @Description:
 * 飞致云面试题
 * 为LinkedList排序
 *
 * 使用LinkedList的add方法
 * 不要用Collections.sort之类现成的方法
 * 不要用冒泡类排序算法，不要想太复杂
 * @Date 2019/3/31 13:46
 * @Version 1.0
 */
public class ListSort {

    /**
     *
     */
    private static List<Integer> sSorted = new LinkedList<>();

    /**
     *
     * @param e
     */
    private static void addElement(int e){
        boolean b = sSorted.isEmpty();
        if (!b){
            int size =sSorted.size();
            int location = 0;
            for (int i = 0; i < size; i++) {
                if (sSorted.get(i)<e){
                    location += 1;
                }
            }
            sSorted.add(location,e);
        }else {
            sSorted.add(e);
        }
    }

    public static void main(String[] args) {
        ListSort.addElement(3);
        ListSort.addElement(2);
        ListSort.addElement(888);
        ListSort.addElement(99);
        System.out.println(sSorted);
    }
}
