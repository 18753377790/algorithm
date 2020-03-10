package com.algorithm.lb.tree;

import java.util.Objects;

/**
 * @Author 李非凡
 * @Description:
 * 二叉树：一种特殊的树形结构，每个节点至多只有两颗（0，1，2）子树。
 *
 * 红黑树
 * HashMap
 * Windows的目录搜索
 *
 * B树
 * MySQL索引
 *
 * Array.sort()用的归并排序，通过二叉树实现
 *
 * 二叉树的遍历：遍历输出都是从根结点开始
 * 前序 pre order
 * 中序 in order
 * 后序 post order
 *
 * 树的特点
 * 1.有一个根结点，一般称为root结点
 * 2.每一个元素都被称为node
 * 3.除了root结点外，其余的结点都会被分成n个互不相交的集合，子树。递归
 * @Date 2019/9/16 20:54
 * @Version 1.0
 */
public class BinaryTree {

    public static void main(String[] args) {
        Node D = new Node('D',null,null);
        Node H = new Node('H',null,null);
        Node K = new Node('K',null,null);
        Node C = new Node('C',D,null);
        Node B = new Node('B',null,C);
        Node G = new Node('G',H,K);
        Node F = new Node('F', G, null);
        Node E = new Node('E', null, F);
        Node A = new Node('A', B, E);// 根节点

        BinaryTree binaryTree = new BinaryTree();
        System.out.println("前序遍历");// ABCDEFGHK
        binaryTree.preOrder(A);
        System.out.println("中序遍历");// BDCAEHGKF
        binaryTree.inOrder(A);
        System.out.println("后序遍历");// DCBHKGFEA
        binaryTree.postOrder(A);

    }

    private void print(Node node){
        System.out.print(node.getData());
    }

    /**
     * 前序遍历 根结点（输出） 左子树 右子树
     * @param root 结点
     */
    private void preOrder(Node root){
        print(root);
        if (!Objects.isNull(root.getLeftNode())) {
            preOrder(root.getLeftNode());
        }
        if (!Objects.isNull(root.getRightNode())) {
            preOrder(root.getRightNode());
        }
    }

    /**
     * 中序遍历  左子树 根结点（输出） 右子树
     * @param root 结点
     */
    private void inOrder(Node root){
        if (!Objects.isNull(root.getLeftNode())) {
            inOrder(root.getLeftNode());
        }
        print(root);
        if (!Objects.isNull(root.getRightNode())) {
            inOrder(root.getRightNode());
        }
    }

    /**
     * 后序遍历 左子树 右子树 根结点（输出）
     * @param root 结点
     */
    private void postOrder(Node root){
        if (!Objects.isNull(root.getLeftNode())) {
            postOrder(root.getLeftNode());
        }
        if (!Objects.isNull(root.getRightNode())) {
            postOrder(root.getRightNode());
        }
        print(root);
    }
}

/**
 * 结点类
 */
class Node{

    /**
     * 结点的数据
     */
    private char data;

    /**
     * 左结点
     */
    private Node leftNode;

    /**
     * 右结点
     */
    private Node rightNode;

    public Node(char data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}