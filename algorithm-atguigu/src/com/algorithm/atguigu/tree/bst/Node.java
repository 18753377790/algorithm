package com.algorithm.atguigu.tree.bst;

/**
 * @Author 李非凡
 * @Description: 二叉排序树的结点
 * @Date 2020/3/10 11:28
 * @Version 1.0
 */
public class Node {

    /**
     *
     */
    private int value;

    /**
     * 左指针
     */
    private Node left;

    /**
     * 右指针
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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
