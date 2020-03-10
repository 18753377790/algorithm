package com.algorithm.atguigu.tree;

/**
 * @Author 李非凡
 * @Description: 顺序存储二叉树演示
 * @Date 2020/3/9 0:53
 * @Version 1.0
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        // 创建一个顺序存储二叉树
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        // 前序遍历，1245367
        arrayBinaryTree.preOrder();
    }
}
