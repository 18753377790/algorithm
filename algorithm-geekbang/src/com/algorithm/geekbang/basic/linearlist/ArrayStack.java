package com.algorithm.geekbang.basic.linearlist;

/**
 * @Author 李非凡
 * @Description:
 * 顺序栈-用数组定义栈（基于数组实现的顺序栈）
 *
 * 当某个数据集合只涉及在一端插入和删除数据，并且满足后进先出、先进后出的特性，就应该首选“栈”这种数据结构。
 *
 * 时间复杂度 O(1)
 * 空间复杂度 O(1)
 * @Date 2019/9/30 14:32
 * @Version 1.0
 */
public class ArrayStack {

    /**
     *  数组
     */
    private String[] items;

    /**
     * 栈中元素个数
     */
    private int count;

    /**
     * 栈的大小
     */
    private int n;

    /**
     * 初始化数组，申请一个大小为 n 的数组空间
     * @param n 栈的大小
     */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈操作
     * @param item 入栈的元素
     * @return 入栈操作是否成功
     */
    public boolean push(String item) {
        // 数组空间不够了，直接返回 false，入栈失败。
        if (count == n) {
            return false;
        }
        // 将 item 放到下标为 count 的位置，并且 count 加一
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     * @return 出栈的元素
     */
    public String pop() {
        // 栈为空，则直接返回 null
        if (count == 0) {
            return null;
        }
        // 返回下标为 count-1 的数组元素，并且栈中元素个数 count 减一
        String tmp = items[count - 1];
        --count;
        return tmp;
    }
}
