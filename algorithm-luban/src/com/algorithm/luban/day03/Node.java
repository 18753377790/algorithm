package com.algorithm.luban.day03;

/**
 * @Author 李非凡
 * @Description:
 * 结点类
 * 用于单链表的结点类，单链表实现栈和队列
 * @Date 2019/4/12 21:09
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

    public Node(Object value){
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
