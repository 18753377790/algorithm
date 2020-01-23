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
 *
 * 堆化
 * 一个包含 n 个节点的完全二叉树，树的高度不会超过 log2 n。
 * 堆化的过程是顺着节点所在路径比较交换的，所以堆化的时间复杂度跟树的高度成正比，也就是O(log n)。
 * 插入数据和删除堆顶元素的主要逻辑就是堆化，所以，往堆中插入一个元素和删除堆顶元素的时间复杂度都是 O(log n)。
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

    /**
     *
     */
    private static final int NUM = 2;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入元素
     * 从下往上的堆化
     * @param data 待插入的元素
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        // 自下往上堆化
        while (i / NUM > 0 && a[i] > a[i / NUM]) {

            i = i / NUM;
        }
    }

    /**
     * 删除对顶元素（大顶堆）
     * 从上往下的堆化。
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 自上往下堆化
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * NUM <= n) {

            }
        }
    }

    /**
     * 建堆
     * @param a
     * @param n
     */
    private void buildHeap(int[] a, int n) {

    }
}
