package com.atguigu.datastructure.tree.avl;

/**
 * @Author 李非凡
 * @Description: 平衡二叉搜索树（AVL树）结点
 * @Date 2020/3/10 23:43
 * @Version 1.0
 */
public class Node {

    /**
     * 结点的值
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
