package com.algorithm.atguigu.linkedlist;

/**
 * @Author 李非凡
 * @Description: 单链表结点
 * 定义HeroNode，每个HeroNode对象就是一个结点
 * @Date 2020/3/1 21:33
 * @Version 1.0
 */
public class HeroNode {

    /**
     * 排名编号
     */
    public int no;

    /**
     * 名字
     */
    public String name;

    /**
     * 昵称
     */
    public String nickname;

    /**
     * 指向下一个结点
     */
    public HeroNode next;

    /**
     * 构造器
     * @param no
     * @param name
     * @param nickname
     */
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * 为了显示方便，重写toString方法
     * 注意不要打印next，否则一次会打印多个结点
     * @return
     */
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
