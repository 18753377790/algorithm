package com.atguigu.datastructure.tree;

/**
 * @Author 李非凡
 * @Description: 二叉树演示
 * @Date 2020/3/8 10:38
 * @Version 1.0
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        // 创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "卢俊义");
        HeroNode node3 = new HeroNode(3, "吴用");
        HeroNode node4 = new HeroNode(4, "公孙胜");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 手动创建二叉树（以后改成递归创建二叉树）
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        System.out.println("前序遍历：");
        // 1->2->3->5->4
        binaryTree.preOrder(root);

        System.out.println("中序遍历：");
        // 2->1->5->3->4
        binaryTree.inOrder(root);

        System.out.println("后序遍历：");
        // 2->5->4->3->1
        binaryTree.postOrder(root);

        /*
         前序查找
         前序查找的次数
         */
        System.out.println("前序查找");
        HeroNode preResult = binaryTree.preOrderSearch(root, 5);
        if (preResult != null) {
            System.out.println(preResult);
        }else {
            System.out.println("没有找到");
        }


        /*
         中序查找
         中序查找的次数
         */
        System.out.println("中序查找");
        HeroNode inResult = binaryTree.inOrderSearch(root, 5);
        if (inResult != null) {
            System.out.println(inResult);
        }else {
            System.out.println("没有找到");
        }

        /*
         后序查找
         后序查找的次数
         */
        System.out.println("后序查找");
        HeroNode postResult = binaryTree.postOrderSearch(root, 5);
        if (postResult != null) {
            System.out.println(postResult);
        }else {
            System.out.println("没有找到");
        }

        System.out.println("删除前：");
        binaryTree.preOrder(root);
        binaryTree.delete(root, 5);
        binaryTree.delete(root, 3);
        System.out.println("删除后：");
        binaryTree.preOrder(root);
    }
}
