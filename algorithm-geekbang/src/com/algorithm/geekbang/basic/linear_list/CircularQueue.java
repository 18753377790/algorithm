package com.algorithm.geekbang.basic.linear_list;

/**
 * @Author 李非凡
 * @Description:
 * 循环队列
 * 要想写出没有 bug 的循环队列的实现代码，确定好队空和队满的判定条件
 * 队列为空的判断条件是 head == tail
 * 队列满了的判断条件是 (tail+1)%n=head。
 * @Date 2019/9/30 15:52
 * @Version 1.0
 */
public class CircularQueue {

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
     * 申请一个大小为 capacity 的数组
     * @param capacity 数组容量
     */
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     * @param item 入队的元素
     * @return 入队操作是否成功
     */
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head)
            return false;
        items[tail] = item;
        tail = (tail + 1) % n;
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
        head = (head + 1) % n;
        return ret;
    }
}
