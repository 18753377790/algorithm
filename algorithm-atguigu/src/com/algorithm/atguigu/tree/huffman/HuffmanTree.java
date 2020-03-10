package com.algorithm.atguigu.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 李非凡
 * @Description: 赫（哈）夫曼树（最优二叉树）
 * 一、赫夫曼树介绍：
 * 1.给定n个权值作为n个叶子结点，构造一颗二叉树，若该树的带权路径长度（WPL）达到最小，
 *   称这样的树为最优二叉树。
 * 2.赫夫曼树是带权路径长度最短的树，权值较大的结点离根很近
 *
 * 二、赫夫曼树的概念：
 * 1.路径：
 * 2.路径长度：
 * 3.结点的权：
 * 4.带权路径长度：
 * 5.树的带权路径长度：树的带权路径长度规定为所有的叶子结点的带权路径长度之和，记为WPL，
 * 权值越大的结点离根结点越近的二叉树才是最优二叉树，即：WPL最小的就是赫夫曼树
 *
 * 三、赫夫曼树创建思路
 * 1.
 * 2.
 * 3.
 * 4.
 * @Date 2020/3/9 21:18
 * @Version 1.0
 */
public class HuffmanTree {

    /**
     * 根结点
     */
    private Node root;

    public static void main(String[] args) {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        Node node = createHuffmanTree(array);
        preOrder(node);
    }

    /**
     * 创建赫夫曼树的方法
     * @param array 需要创建成赫夫曼树的数组
     * @return 赫夫曼树的根结点
     */
    private static Node createHuffmanTree(int[] array) {
        /*
        为了操作方便
        1.遍历array数组
        2.将array每个元素构建成一个Node
        3.将node放入到List中
         */
        List<Node> nodes = new ArrayList<>();

        for (int value : array) {
            nodes.add(new Node(value));
        }

        // 处理的过程是循环的过程
        while (nodes.size() > 1) {
            // 从小到大排序
            Collections.sort(nodes);

            /*
             取出根结点权值最小的两颗二叉树
             1、取出权值最小的结点（只有根结点的二叉树）
             */
            Node leftNode = nodes.get(0);

            // 2.取出权值第二小的结点（只有根结点的二叉树）
            Node rightNode = nodes.get(1);

            // 3.构建一颗新的二叉树
            Node parentNode = new Node(leftNode.getValue() + rightNode.getValue());
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);

            // 4.从List中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // 5.将新构建的结点加入到List
            nodes.add(parentNode);
        }

        // 返回赫夫曼树的根结点
        return nodes.get(0);
    }

    /**
     * 前序遍历
     * @param root 根结点
     */
    private static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root);

            if (root.getLeft() != null) {
                preOrder(root.getLeft());
            }

            if (root.getRight() != null) {
                preOrder(root.getRight());
            }
        }else {
            System.out.println("赫夫曼树为空树");
        }
    }
}
