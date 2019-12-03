package com.algorithm.geekbang.basic.heap;

/**
 * @Author 李非凡
 * @Description:
 * 堆
 * 堆的定义：
 * 1.堆是一个完全二叉树。
 * 2.堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
 *
 * 大顶堆：每个节点的值都大于等于子树中每个节点值的堆，叫作“大顶堆”。
 * 小顶堆：每个节点的值都小于等于子树中每个节点值的堆，叫作“小顶堆”。
 *
 * 堆的存储：
 * 完全二叉树比较适合用数组来存储，所以堆通常都使用数组来进行存储
 * @Date 2019/10/14 21:05
 * @Version 1.0
 */
public class Heap {

    /**
     * 数组，从下标为1开始存储数据
     */
    private int[] a;

    /**
     * 堆可以存储的最大数据个数
     */
    private int n;

    /**
     * 堆中已经存储的数据个数
     */
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = data;
    }


    public void removeMax() {

    }

    /**
     *
     */
    private void heapify() {

    }

    private void buildHeap(int[] a, int n) {

    }
}
