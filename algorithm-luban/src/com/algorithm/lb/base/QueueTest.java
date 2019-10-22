package com.algorithm.lb.base;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author 李非凡
 * @Description:
 * 队列介绍
 * @Date 2019/5/19 1:04
 * @Version 1.0
 */
public class QueueTest {

    public static void main(String[] args) {
        // 等待队列
        // 排队场景
        // MQ消息队列
        // 做阻塞take()阻塞队列，take();会一直阻塞到有数据为止，可以用在并发场景

        // ArrayBlockingQueue基于数组的阻塞队列，有界队列
        // LinkedBlockingQueue基于链表的阻塞队列，无界队列，防止内存溢出
        // DelayQueue<Delayed>带延时的 连接池的关闭

        // 优先队列
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        Task e = new Task();
        e.setValue(1);
        queue.add(e);

        Task b = new Task();
        b.setValue(2);
        queue.add(b);
    }
}

/**
 * 优先队列
 */
class Task implements Comparable<Task>{

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Task o) {
        return this.value > o.value ? 1 : -1;
    }
}