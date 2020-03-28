package com.atguigu.datastructure.queue;

/**
 * @Author 李非凡
 * @Description: 顺序队列，数组实现
 * 使用数组模拟队列
 * 缺点：目前数组使用一次就不能用，没有达到复用的效果
 * 改进方案：改进成一个环形队列（取模%）
 * 队列最大容量：maxSize
 * 判断队满的条件：rear 等于 maxSize - 1        (rear+1)%maxSize == front/(rear+maxSize-front)%maxSize
 * 判断队空的条件：rear == front
 * @Date 2020/3/1 9:23
 * @Version 1.0
 */
public class ArrayQueue {

    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队头指针：front指向队列第一个元素的前面一个
     */
    private int front;

    /**
     * 队尾指针
     */
    private int rear;

    /**
     * 该数组用于存放数据，模拟队列
     */
    private int[] array;

    /**
     * 创建队列的构造器
     * @param arrayMaxsize 数组的最大值
     */
    public ArrayQueue(int arrayMaxsize) {
        this.maxSize = arrayMaxsize;
        array = new int[maxSize];
        // 指向队列头部，分析出是指向队列头的前一个位置
        front = -1;
        // 指向队列尾部，指向队列尾的数据（即就是队列最后一个数据）
        rear = -1;
    }

    /**
     * 判断队满是否满
     * @return
     */
    public boolean isFull() {
        // 数组下标从0开始，所以栈满的标志是array.length - 1
        return rear == maxSize - 1;
    }

    /**
     * 判断对空是否空
     * @return
     */
    public boolean isEmpty() {
       return front == rear;
    }

    /**
     * 添加数据到队列，入队
     * @param n
     */
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        // 让队尾指针后移
        rear++;
        array[rear] = n;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 队头指针后移
        front++;
        return array[front];
    }

    /**
     * 显示队列的所有数据，遍历数组
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     * @return
     */
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        // front本来是指向队列头的前一个数据
        return array[front + 1];
    }
}
