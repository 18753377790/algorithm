package com.algorithm.luban.day02;

/**
 * @Author 李非凡
 * @Description:
 * 结点类
 * 链表的结点：数据和下一个结点的地址
 * @Date 2019/4/10 0:28
 * @Version 1.0
 */
public class Node {

    /**
     * 数据
     */
    private Object value;

    /**
     * 下一个结点的地址
     */
    private Node next;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
