package com.algorithm.atguigu.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/8 1:09
 * @Version 1.0
 */
public class Array {

    public static void main(String[] args) {
        /*
         以ArrayList1为例子看看怎样进行数组扩容
         ArrayList底层维护了一个transient Object[] elementData
         初始化的时候是一个空数组DEFAULTCAPACITY_EMPTY_ELEMENTDATA
         ArrayList底层依靠grow()方法来进行数组扩容
         1.7初始容量为10
         1.8以后初始容量为0，可以指定容量capacity

         1.7扩容为1.5倍扩容
         1.8如果初始未指定容量，则先扩容为10，然后再以1.5倍扩容，如果指定了容量capacity，则直接1.5倍扩容
         */
        List<Integer> list = new ArrayList<>();
    }
}
