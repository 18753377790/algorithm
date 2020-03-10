package com.algorithm.atguigu.linkedlist;

/**
 * @Author 李非凡
 * @Description: 约瑟夫问题（约瑟夫环）
 * @Date 2020/3/3 10:20
 * @Version 1.0
 */
public class JosephusProblem {

    public static void main(String[] args) {
        // 测试单向环形链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        // 加入5个小孩结点
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.showNode();

        // 测试小孩结点出圈，2->4->1->5->3
        circleSingleLinkedList.countNode(1, 2,5);
    }
}
