package com.algorithm.offer.linkedlist;

/**
 * @Author 李非凡
 * @Description: 链表的结点
 * @Date 2019/10/23 11:40
 * @Version 1.0
 */
public class ListNode {

    /**
     * 结点的值
     */
    int val;

    /**
     * 结点的指针，指向下一个结点
     */
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
