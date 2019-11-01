package com.algorithm.tree;

/**
 * @Author 李非凡
 * @Description:
 * 二叉树结点类
 * @Date 2019/10/23 11:27
 * @Version 1.0
 */
public class TreeLinkNode {

    /**
     *
     */
    int val;

    /**
     * 左结点
     */
    TreeLinkNode left = null;

    /**
     * 右结点
     */
    TreeLinkNode right = null;

    /**
     * 父结点
     */
    TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
