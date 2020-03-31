package com.fundamental.algorithm.lb.tree;

/**
 * @Author 李非凡
 * @Description:
 * B树（多叉树）
 * M阶的Btree的几个重要特性：
 * 1.结点最多含有m颗子树(指针)，m-1个关键字(存的数据，空间)（m>=2），即指针比空间永远多一个
 * 2.除根结点和叶子结点外，其它每个结点至少有ceil(m / 2)个子节点，ceil为上取整
 * 3.若根节点不是叶子节点，则至少有两颗子树。
 * B+Tree和BTree类似，只是B+Tree非叶子节点不会存储数据，所有的数据都存储在叶子节点，其目的主要增加了系统的稳定性。
 * @Date 2019/9/21 20:55
 * @Version 1.0
 */
public class BTree {

    /**
     *
     */
    private int M;

    /**
     *
     */
    private BTreeNode root;

    public static void main(String[] args) {

    }
}

/**
 * BT树结点类
 */
class BTreeNode{

    /**
     * 表示每个结点最少的值个数 m/2
     */
    private int T;

    /**
     * 结点值个数
     */
    private int count;

    /**
     * 关键字个数，存储数据
     */
    private int[] key;

    /**
     * 指针个数，存储地址
     */
    private BTreeNode[] children;

    /**
     * 判断是否是叶子结点
     */
    private boolean isLeaf;

    public BTreeNode(int t) {
        T = t;
    }
}