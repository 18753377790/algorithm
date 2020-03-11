package com.datastructure.linkedlist;

/**
 * @Author 李非凡
 * @Description: 单链表（带头结点的单链表）
 * 定义单链表，管理英雄
 * 链表分带头结点的链表和没有头结点的链表，根据实际的需求来确定
 * @Date 2020/3/1 21:33
 * @Version 1.0
 */
public class SingleLinkedList {

    /**
     * 先初始化一个头结点，头结点不要动，不存放具体的数据
     */
    private HeroNode head = new HeroNode(0, null, null);

    /**
     * 返回头结点
     * @return
     */
    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加结点到单链表
     * 思路：当不考虑编号顺序时
     * 1.找到当前链表的最后结点
     * 2.将最后这个结点的next指向新的结点
     * @param node
     */
    public void add(HeroNode node) {
        // 因为head结点，因此需要一个辅助变量temp
        HeroNode temp = head;
        // 遍历链表，找到最后（找到链表的最后，相当于循环里面加了if temp.next ==null break）
        while (temp.next != null) {
            // 如果没有找到，就将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        temp.next = node;
    }

    /**
     * 第二种添加的方式，按编号顺序添加
     * @param node
     */
    public void addByOrder(HeroNode node) {
        /*
         因为头结点不能动，因此通过一个辅助指针（变量）来帮助找到添加的位置
         因为是单链表，因此要找的temp是位于添加位置的前一个结点，否则无法插入
         */
        HeroNode temp = head;
        // flag标识添加的编号是否存在，默认为false（不存在）
        boolean flag = false;
        while (true) {
            // 说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            // 位置找到，就在temp的后面插入（即temp和temp.next之间）
            if (temp.next.no > node.no) {
                break;
                // 说明希望添加的heroNode的编号已经存在
            }else if (temp.next.no == node.no) {
                // 说明编号存在
                flag = true;
                break;
            }
            // 后移，遍历当前链表
            temp = temp.next;
        }
        // 判断flag的值
        if (flag) {
            // 不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n", node.no);
        }else {
            // 插入到链表中temp的后面
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 修改结点的信息，根据no编号来修改，即no编号不能改
     * 说明：根据node的no来修改即可
     * @param node
     */
    public void update(HeroNode node) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        /*
         找到需要修改的结点，根据no编号
         定义一个辅助变量
         */
        HeroNode temp = head.next;
        // 表示是否找到该结点
        boolean flag = false;
        while (true) {
            // 已经遍历完链表
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的结点
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        }else {
            System.out.printf("没有找到编号%d的结点，不能修改\n", node.no);
        }
    }

    /**
     * 删除结点
     * 思路
     * 1.head结点不能动，因此需要一个temp辅助结点找到待删除结点的前一个结点
     * 2.在比较时，是temp.next.no和需要删除的结点的no比较
     * @param no
     */
    public void delete(int no) {
        HeroNode temp = head;
        // 标识是否找到待删除结点前一个结点
        boolean flag = false;
        while (true) {
            // 已经到链表的最后
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                // 找到了待删除结点的前一个结点temp
                flag = true;
                break;
            }
            // temp后移，遍历
            temp = temp.next;
        }
        // 判断flag，找到
        if (flag) {
            // 可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d结点不存在\n", no);
        }
    }

    /**
     * 显示链表（遍历）
     */
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        // 遍历链表，找到最后（找到链表的最后，相当于循环里面加了if temp.next ==null break）
        while (temp != null) {
            // 输出结点的信息
            System.out.println(temp);
            // 将temp后移，一定小心
            temp = temp.next;
        }
    }
}
