package com.algorithm.geekbang.basic.linear_list;

/**
 * @Author 李非凡
 * @Description:
 * 顺序队列->用数组实现的队列
 * 队列和栈都是操作受限的线性表数据结构。
 *
 * 队列需要两个指针：一个是 head 指针，指向队头；一个是 tail 指针，指向队尾。
 * @Date 2019/9/30 15:04
 * @Version 1.0
 */
public class ArrayQueue {

    /**
     * 数组：items
     */
    private String[] items;

    /**
     * 数组大小：n
     */
    private int n;

    /**
     * head表示队头下标
     */
    private int head = 0;

    /**
     * tail表示队尾下标
     */
    private int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     * @param capacity 数组容量
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     * @param item 入队的元素
     * @return 入队操作是否成功
     */
    public boolean enqueue(String item) {
        //  如果 tail == n 表示队列已经满了
        if (tail == n)
            return false;

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 入队操作，将item放入队尾
     * @param item 入队的元素
     * @return 入队操作是否成功
     */
    public boolean enqueuePlus(String item) {

        if (tail == n) {
            if (head == 0)
                return false;

            if (tail - head >= 0) System.arraycopy(items, head, items, 0, tail - head);

            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     * @return 出队的元素
     */
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail)
            return null;
        String ret = items[head];
        ++head;
        return ret;
    }
}
