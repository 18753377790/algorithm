package com.datastructure.queue;

/**
 * @Author 李非凡
 * @Description: 环形队列，数组实现
 * @Date 2020/3/1 17:02
 * @Version 1.0
 */
public class CircleArrayQueue {

    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队头指针：front指向队列的第一个元素，初始值为0
     * 也就是说array[front]就是队列的第一个元素
     */
    private int front;

    /**
     * 队尾指针：rear指向队列最后一个元素的后一个位置，初始值为0
     * 因为希望空出一个空间做为约定
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
    public CircleArrayQueue(int arrayMaxsize) {
        this.maxSize = arrayMaxsize;
        array = new int[maxSize];
    }

    /**
     *  求出当前队列有效数据的个数，即队列长度
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 判断队满是否满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        // 直接将数据加入
        array[rear] = n;
        // 将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
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
        /*
         这里需要分析出front是指向队列的第一个元素
         1.先把front对应的值保存到一个临时变量
         2.将front后移，考虑取模
         3.将临时保存的变量返回
         */
        int value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列的所有数据，遍历数组
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        // 思路：从front开始遍历，遍历front + 队列长度个元素
        for (int i = front; i < front + size(); i++) {
            // 因为是环形队列，所以i有可能超过数组长度，这里输出时有问题，下标有时打印会越界
            System.out.printf("array[%d]=%d\n", i % maxSize, array[i % maxSize]);
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
        return array[front];
    }
}
