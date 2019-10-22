package com.algorithm.practice.tree;

/**
 * @Author 李非凡
 * @Description:
 * 节点类
 * @Date 2019/8/20 21:30
 * @Version 1.0
 */
public class Node {

    /**
     * 分数
     */
    private int score;

    /**
     * 节点
     */
    private Node node;

    /**
     * 左儿子
     */
    private Node left;

    /**
     * 右儿子
     */
    private Node right;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
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
