package com.datastructure.linkedlist;

/**
 * @Author 李非凡
 * @Description: 双向链表（带头结点的双向链表）
 * 思考题：第二种添加的方式，按编号顺序添加（根据单链表的顺序添加进行修改）
 * @Date 2020/3/2 23:26
 * @Version 1.0
 */
public class DoubleLinkedList {

    /**
     * 先初始化一个头结点，头结点不要动，不存放具体的数据
     */
    private HeroNode2 head = new HeroNode2(0, null, null);

    /**
     * 返回头结点
     * @return
     */
    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 添加结点到双向链表
     * 思路：当不考虑编号顺序时
     * 1.先找到双向链表的最后这个结点
     * 2.temp.next = newNode
     * 3.newNode.pre = temp
     * @param node
     */
    public void add(HeroNode2 node) {
        // 因为head结点，因此需要一个辅助变量temp
        HeroNode2 temp = head;
        // 遍历链表，找到最后（找到链表的最后，相当于循环里面加了if temp.next ==null break）
        while (temp.next != null) {
            // 如果没有找到，就将temp后移
            temp = temp.next;
        }
        /*
         当退出while循环时，temp就指向了链表的最后
         形成一个双向链表
         */
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 第二种添加的方式，按编号顺序添加（根据单链表的顺序添加进行修改）
     * @param node
     */
    public void addByOrder(HeroNode node) {

    }

    /**
     * 修改一个结点的内容
     * 双向链表的结点内容修改和单链表一样
     * 只是结点的类型改变
     * @param node
     */
    public void update(HeroNode2 node) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        /*
         找到需要修改的结点，根据no编号
         定义一个辅助变量
         */
        HeroNode2 temp = head.next;
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
     * 从双向链表中删除结点
     * 说明：
     * 1.对于双向链表，可以直接找到要删除的结点
     * 2.找到后自我删除即可
     * 3.temp.pre.next = temp.next
     * 4.temp.next.pre = temp.pre
     * @param no
     */
    public void delete(int no) {
        // 判断当前链表是否为空
        if (head.next == null) {
            // 空链表
            System.out.println("链表为空，无法删除");
            return;
        }
        // 辅助变量（指针）
        HeroNode2 temp = head.next;
        // 标识是否找到待删除结点前一个结点
        boolean flag = false;
        while (true) {
            // 已经到链表的最后（最后结点的next）
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
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
            // 单链表删除：temp.next = temp.next.next
            temp.pre.next = temp.next;
            if (temp.next != null) {
                // 这里代码有问题，如果是最后一个结点，就不需要执行下面这段代码，否则会出现空指针异常
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("要删除的%d结点不存在\n", no);
        }
    }

    /**
     * 显示链表（遍历双向链表）
     */
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头结点不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        // 遍历链表，找到最后（找到链表的最后，相当于循环里面加了if temp.next ==null break）
        while (temp != null) {
            // 输出结点的信息
            System.out.println(temp);
            // 将temp后移，一定小心
            temp = temp.next;
        }
    }
}
