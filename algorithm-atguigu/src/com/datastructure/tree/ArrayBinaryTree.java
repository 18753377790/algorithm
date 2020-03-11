package com.datastructure.tree;

/**
 * @Author 李非凡
 * @Description: 顺序存储二叉树，数组实现
 * 从数据存储来看，数组存储方式和树的存储方式可以相互转换
 *
 * 顺序存储二叉树的特点：
 * 1.顺序存储二叉树通常只考虑完全二叉树
 * 2.第n个元素的左子结点为2*n+1
 * 3.第n个元素的右子结点为2*n+2
 * 4.第n个元素的父结点为(n-1)/2
 * 5.n:表示二叉树中的第几个元素（按0开始编号）
 * @Date 2020/3/9 0:53
 * @Version 1.0
 */
public class ArrayBinaryTree {

    /**
     * 存储数据结点的数组
     */
    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    /**
     * 重载前序遍历preOrder
     */
    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 重载中序遍历inOrder
     */
    public void inOrder() {
        this.inOrder(0);
    }

    /**
     * 重载后序遍历postOrder
     */
    public void postOrder() {
        this.postOrder(0);
    }

    /**
     * 前序遍历（顺序存储二叉树）
     * @param index 数组下标（根结点）
     */
    public void preOrder(int index) {
        // 如果数组为空或者数组长度为0，则无法遍历
        if (array == null || array.length == 0) {
            System.out.println("数组为空，不能进行前序遍历");
        }
        // 输出当前元素
        System.out.println(array[index]);
        // 向左递归遍历
        if (index * 2 + 1 < array.length) {
            preOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if (index * 2 + 2 < array.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 中序遍历
     * @param index 数组下标（根结点）
     */
    public void inOrder(int index) {
        // 如果数组为空或者数组长度为0，则无法遍历
        if (array == null || array.length == 0) {
            System.out.println("数组为空，不能进行前序遍历");
        }
        // 向左递归遍历
        if (index * 2 + 1 < array.length) {
            preOrder(index * 2 + 1);
        }
        // 输出当前元素
        System.out.println(array[index]);
        // 向右递归遍历
        if (index * 2 + 2 < array.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 后序遍历
     * @param index 数组下标（根结点）
     */
    public void postOrder(int index) {
        // 如果数组为空或者数组长度为0，则无法遍历
        if (array == null || array.length == 0) {
            System.out.println("数组为空，不能进行前序遍历");
        }
        // 向左递归遍历
        if (index * 2 + 1 < array.length) {
            preOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if (index * 2 + 2 < array.length) {
            preOrder(index * 2 + 2);
        }
        // 输出当前元素
        System.out.println(array[index]);
    }
}
