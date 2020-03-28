package com.atguigu.datastructure.tree.huffman;

/**
 * @Author 李非凡
 * @Description: 赫夫曼树的结点
 * 为了让HuffmanNode结点类支持排序（例如Collection集合排序）
 * @Date 2020/3/9 22:32
 * @Version 1.0
 */
public class Node implements Comparable<Node>{

    /**
     * 结点权值
     */
    private int value;

    /**
     * 左子结点
     */
    private Node left;

    /**
     * 右子结点
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

    @Override
    public int compareTo(Node o) {
        // 表示从小到大进行排序（从大到小排序为-(this.value - o.value)）
        return this.value - o.value;
    }
}
