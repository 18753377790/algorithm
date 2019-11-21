package com.algorithm.geekbang.advanced.btree;

/**
 * @Author 李非凡
 * @Description:
 * B+树非叶子结点类
 * @Date 2019/11/21 22:13
 * @Version 1.0
 */
public class BPlusTreeNode {

    /**
     * 5叉树
     */
    private static int m = 5;

    /**
     *
     */
    private int[] keywords = new int[m - 1];

    /**
     *
     */
    private BPlusTreeNode[] children = new BPlusTreeNode[m];
}
