package com.atguigu.datastructure.linkedlist;

import java.util.Stack;

/**
 * @Author 李非凡
 * @Description: 单链表演示
 * 思考题：合并两个有序的单链表，合并之后的链表依然有序（提示：参考单链表反转）
 * @Date 2020/3/1 21:44
 * @Version 1.0
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        System.out.println("单链表的测试");

        // 创建结点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        // 创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 加入链表
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero3);

        // 加入按照编号的排序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        // 显示链表
        singleLinkedList.list();

        //修改结点
        HeroNode newHero2 = new HeroNode(2, "卢", "麒麟");
        singleLinkedList.update(newHero2);
        System.out.println("修改后的链表情况：");
        // 显示链表
        singleLinkedList.list();

        // 删除一个结点
//        singleLinkedList.delete(1);
        // 删除最后一个结点
        singleLinkedList.delete(4);
        System.out.println("删除后链表的情况：");
        // 显示链表
        singleLinkedList.list();

        // 测试求单链表中有效结点的个数
        System.out.println("有效的结点个数=" + getLength(singleLinkedList.getHead()));

        // 测试查询单链表中的倒数第k个结点
        HeroNode result = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("result=" + result);

        // 测试单链表的反转
        System.out.println("初始单链表");
        singleLinkedList.list();
        System.out.println("反转单链表");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        // 测试逆序打印单链表
        System.out.println("逆序打印单链表（没有改变链表的结构）：");
        reversePrint(singleLinkedList.getHead());
    }

    /**
     * 求单链表中有效结点的个数
     * 方法：获取到单链表的结点个数（如果是带头结点的链表，需求不统计头结点）
     * @param head 链表的头结点
     * @return 返回的就是有效结点的个数
     */
    private static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        // 定义一个辅助的变量，这里没有统计头结点
        HeroNode current = head.next;
        while (current != null) {
            length++;
            // 遍历
            current = current.next;
        }
        return length;
    }

    /**
     * 查询单链表中的倒数第k个结点（新浪面试题）
     * 思路：
     * 1.编写一个方法，接收head结点，同时接收一个index
     * 2.index表示是倒数第index结点
     * 3.先把链表从头到尾遍历，得到链表的总长度size（getLength方法）
     * 4.得到了size后，从链表的第一个开始遍历（length-index）个，就可以得到
     * 5.如果找到了，则返回该结点，否则返回null
     * @param head 链表的头结点
     * @param index
     * @return
     */
    private static HeroNode findLastIndexNode(HeroNode head, int index) {
        // 判断如果链表为空，返回null
        if (head.next == null) {
            return null;
        }
        // 第一次遍历得到链表的长度（结点个数）
        int size = getLength(head);
        // index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        // 定义一个辅助的变量，这里没有统计头结点
        HeroNode current = head.next;
        /*
         第二次遍历 size - index 位置，就是倒数的第k个结点
         for循环定位到倒数的index
         例：size为3，找倒数第一个，就循环3-1=2次
         */
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * 单链表的反转（腾讯面试题）
     * 思路：
     * 1.先定义一个结点reverseHead = new HeroNode();（用于临时当反转链表的头结点）
     * 2.从头到尾遍历原来的链表，每遍历一个结点，就将其取出，并放在新的链表reverseHead的最前端
     * 3.原来的链表的head.next = reverseHead.next
     * @param head 链表的头结点
     */
    private static void reverseList(HeroNode head) {
        // 如果当前链表为空或者只有一个结点，则无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 定义辅助变量，帮助遍历原来的链表
        HeroNode current = head.next;
        // 指向当前结点（current）的下一个结点，防止链表断掉
        HeroNode next = null;
        // 反转链表的临时头结点
        HeroNode reverseHead = new HeroNode(0, null, null);
        // 遍历原来的链表，每遍历一个结点，就将其取出，并放在新的链表reverseHead的最前端
        while (current != null) {
            // 先暂时保存当前结点的下一个结点，因为后面需要使用
            next = current.next;
            // 将current下一个结点指向新的链表的最前端
            current.next = reverseHead.next;
            // 将current连接到新的链表上
            reverseHead.next = current;
            // 让current后移
            current = next;
        }
        // 将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    /**
     * 从尾到头（逆序）打印单链表（百度面试题）
     * 思路：题目要求就是逆序打印单链表
     * 1.方式1：先将单链表进行反转操作，然后再遍历即可，但是这样做会破坏原来的单链表的结构，不建议使用
     * 2.方式2：可以利用栈这个数据结构，将各个结点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
     * @param head 链表的头结点
     */
    private static void reversePrint(HeroNode head) {
        // 空链表不能打印
        if (head.next == null) {
            return;
        }
        // 创建一个栈，将各个结点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode current = head.next;
        // 将链表的所有结点压入栈中
        while (current != null) {
            stack.push(current);
            // current后移，这样就可以压入下一个结点
            current = current.next;
        }
        // 将栈中的结点进行打印，pop出栈
        while (stack.size() > 0) {
            // 栈的特点是先进后出
            System.out.println(stack.pop());
        }
    }
}
