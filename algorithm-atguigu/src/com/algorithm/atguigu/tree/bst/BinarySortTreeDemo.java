package com.algorithm.atguigu.tree.bst;

/**
 * @Author 李非凡
 * @Description: 二叉排序树演示
 * @Date 2020/3/10 11:24
 * @Version 1.0
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9, 2};

        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环的添加结点到二叉排序树
        for (int value : array) {
            binarySortTree.add(new Node(value));
        }

        System.out.println("中序遍历二叉排序树");
        binarySortTree.inOrder();

        System.out.println("查询值为5的结点" + binarySortTree.search(5));
        System.out.println("查询值为5的结点的父结点" + binarySortTree.searchParent(5));

//        binarySortTree.delete(2);
        binarySortTree.delete(10);
        System.out.println("删除结点后");
        binarySortTree.inOrder();
    }
}
