package com.fundamental.algorithm.luban.day05;

/**
 * @Author 李非凡
 * @Description:
 * 结点类
 * 链表的一个结点中要存储二叉树的左儿子，数据和右儿子
 * @Date 2019/4/14 1:52
 * @Version 1.0
 */
public class Node {

    /**
     * 数据
     */
    private int value;

    /**
     * 左儿子
     */
    private Node left;

    /**
     * 右儿子
     */
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
