package com.datastructure.linkedlist;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/2 23:57
 * @Version 1.0
 */
public class HeroNode2 {
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
     * 指向前一个结点，默认为null
     */
    public HeroNode2 pre;

    /**
     * 指向后一个结点，默认为null
     */
    public HeroNode2 next;

    /**
     * 构造器
     * @param no
     * @param name
     * @param nickname
     */
    public HeroNode2(int no, String name, String nickname) {
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
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
