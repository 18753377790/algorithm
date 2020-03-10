package com.algorithm.atguigu.hash;

/**
 * @Author 李非凡
 * @Description: 雇员类，表示一个雇员，是链表的一个结点
 * @Date 2020/3/7 19:14
 * @Version 1.0
 */
public class Employee {

    /**
     * 雇员id
     */
    public int id;

    /**
     * 雇员姓名
     */
    public String name;

    /**
     * 指向下一结点的指针，默认为空
     */
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
