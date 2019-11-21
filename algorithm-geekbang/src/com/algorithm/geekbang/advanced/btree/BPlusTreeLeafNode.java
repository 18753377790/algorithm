package com.algorithm.geekbang.advanced.btree;

/**
 * @Author 李非凡
 * @Description:
 * B+树叶子结点类
 * @Date 2019/11/21 22:16
 * @Version 1.0
 */
public class BPlusTreeLeafNode {

    /**
     *
     */
    private static int k = 3;

    /**
     *
     */
    private int[] keywords = new int[k];

    /**
     *
     */
    private long[] dataAddress = new long[k];

    /**
     *
     */
    private BPlusTreeLeafNode prev;

    /**
     *
     */
    private BPlusTreeLeafNode next;
}
