package com.atguigu.datastructure.linkedlist;

/**
 * @Author 李非凡
 * @Description: 男孩结点
 * 用于创建单项环形链表解决约瑟夫问题
 * @Date 2020/3/3 10:21
 * @Version 1.0
 */
public class BoyNode {

    /**
     * 编号
     */
    private int no;

    /**
     * 指向下一个结点
     */
    private BoyNode next;

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }
}
