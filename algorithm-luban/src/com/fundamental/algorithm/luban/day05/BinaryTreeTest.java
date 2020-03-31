package com.fundamental.algorithm.luban.day05;

/**
 * @Author 李非凡
 * @Description:
 * 自定义二叉树测试类
 * @Date 2019/4/14 1:54
 * @Version 1.0
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        /*
        使用链表实现二叉树
        中序排序：顺序二叉树使用中序遍历，形成有序的数据
         */
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(1);
        tree.add(4);
        tree.add(8);
        tree.add(2);
        tree.add(7);
        tree.add(9);
        tree.add(3);

        tree.show();
    }
}
