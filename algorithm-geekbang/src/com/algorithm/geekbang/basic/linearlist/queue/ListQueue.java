package com.algorithm.geekbang.basic.linearlist.queue;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2019/10/31 21:00
 * @Version 1.0
 */
public class ListQueue {

    /**
     * 队头指针
     */
    private Node head = null;

    /**
     * 队尾指针
     */
    private Node tail = null;

    /**
     * 队列长度
     */
    private int size = 0;

    /**
     * 内部类作为链表的结点类
     */
    private static class Node {
        // public
        Object item;
        // null
        Node next;

        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
