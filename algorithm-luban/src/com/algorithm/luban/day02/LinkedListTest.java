package com.algorithm.luban.day02;

/**
 * @Author 李非凡
 * @Description:
 * 自定义LinkedList测试类
 * @Date 2019/4/9 0:10
 * @Version 1.0
 */
public class LinkedListTest {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(6);
//        list.set(1, 9);
        list.removeAt(1);
        list.removeAt(2);

        //遍历输出集合
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}
