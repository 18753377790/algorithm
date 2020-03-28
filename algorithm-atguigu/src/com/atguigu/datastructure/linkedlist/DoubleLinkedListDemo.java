package com.atguigu.datastructure.linkedlist;

/**
 * @Author 李非凡
 * @Description: 双向链表演示
 * @Date 2020/3/2 23:26
 * @Version 1.0
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");

        // 创建结点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "公孙胜", "入云龙");

        // 创建双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改结点
        HeroNode2 newHero4 = new HeroNode2(4, "林冲", "豹子头");
        doubleLinkedList.update(newHero4);
        System.out.println("修改后的链表情况：");
        doubleLinkedList.list();

        // 删除结点
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表情况");
        doubleLinkedList.list();
    }
}
