package com.algorithm.geekbang.advanced.btree;

/**
 * @Author 李非凡
 * @Description:
 * B+树非叶子结点类
 * 假设 keywords=[3, 5, 8, 10]
 * 4 个键值将数据分为 5 个区间：(-INF,3), [3,5), [5,8), [8,10), [10,INF)
 * 5 个区间分别对应：children[0]...children[4]
 * m 值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
 * PAGE_SIZE = (m-1)*4[keywordss 大小]+m*8[children 大小]
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
