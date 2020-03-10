package com.algorithm.atguigu.linkedlist;

/**
 * @Author 李非凡
 * @Description: 单向环形链表
 * @Date 2020/3/3 10:23
 * @Version 1.0
 */
public class CircleSingleLinkedList {

    /**
     * 创建一个first结点，当前没有编号
     */
    private BoyNode first = null;

    /**
     * 添加结点，构建成一个环形链表
     * @param nums 添加的结点的个数
     */
    public void add(int nums) {
        // 对nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        // 辅助指针，帮助构建环形链表
        BoyNode current = null;
        // 使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建小孩结点
            BoyNode node = new BoyNode(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = node;
                // 构成一个环
                first.setNext(first);
                // 让current指向第一个boy结点
                current = first;
            }else {
                // 让当前结点的next指向新加入的结点
                current.setNext(node);
                // 让新加入的结点的next指向first结点
                node.setNext(first);
                // 让current指向新增的结点
                current = node;
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showNode() {
        // 判断链表是否为空
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        // 因为first不能动，因此使用一个辅助指针完成遍历
        BoyNode current = first;
        while (true) {
            System.out.printf("小孩的编号%d\n", current.getNo());
            // 说明已经遍历完毕
            if (current.getNext() == first) {
                break;
            }
            // current后移
            current = current.getNext();
        }
    }

    /**
     * 根据用户的输入计算出结点出圈的顺序
     * 思路：
     * 1.需要创建一个辅助指针（变量）helper，事先应该指向环形链表的最后这个结点
     * 补充：小孩报数前，先让first和helper移动k - 1次
     * 2.当小孩报数时，让first和helper指针同时移动m - 1次
     * 3.这时就可以将first指向的小孩结点出圈
     * first = first.next
     * helper.next = first
     * 原来first指向的结点就没有任何引用，就会被回收
     * @param startNo 表示从第几个结点开始数数
     * @param countNum 表示数几次
     * @param nums 表示最初有多少结点在圈中
     */
    public void countNode(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建一个辅助指针（变量），帮助完成结点出圈
        BoyNode helper = first;
        // 需要创建一个辅助指针（变量）helper，事先应该指向环形链表的最后这个结点
        while (true) {
            // 说明helper指向最后的小孩结点
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前，先让first和helper移动k - 1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        /*
         当小孩报数时，让first和helper指针同时移动m - 1次，然后出圈
         这里是一个循环操作，直到圈中只有一个结点
         */
        while (true) {
            // 说明圈中只有一个结点
            if (helper == first) {
                break;
            }
            // 让first和helper指针同时移动countNum - 1次，然后出圈
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first指向的结点就是要出圈的小孩结点
            System.out.printf("小孩%d出圈\n", first.getNo());
            // 这时将first指向的小孩结点出圈
            first = first.getNext();
            // helper.next = first
            helper.setNext(first);
        }
        // 到最后，first和helper会指向同一个结点
        System.out.printf("最后留在圈中的小孩编号%d\n", helper.getNo());
    }
}
