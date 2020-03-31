package com.fundamental.algorithm.lb.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @Author 李非凡
 * @Description:
 * List介绍
 * @Date 2019/5/18 21:51
 * @Version 1.0
 */
public class ListTest {

    public static void main(String[] args) {
        // 数组实现
        List<Integer> integers = new ArrayList<>();
        // 链表实现
        List<Integer> integers2 = new LinkedList<>();
        // 数组实现，但是是线程安全的
        Vector<Integer> vector;

//        for (int i = 0; i < n; i++) {
//
//        }
        /*
        两者的区别
        数组读取灵活，随机访问快，可以用下标
        链表
        多线程的情况下用vector
         */

    }
}
