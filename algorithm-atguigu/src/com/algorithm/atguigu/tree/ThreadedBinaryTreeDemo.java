package com.algorithm.atguigu.tree;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/9 3:45
 * @Version 1.0
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        // 测试中序线索化二叉树
        HeroNode2 root = new HeroNode2(1, "大傻逼傅昶");
        HeroNode2 node2 = new HeroNode2(3, "大傻逼刘泽宏");
        HeroNode2 node3 = new HeroNode2(6, "傻逼武皓");
        HeroNode2 node4 = new HeroNode2(8, "傻逼王文凯");
        HeroNode2 node5 = new HeroNode2(10, "傻逼朱光耀");
        HeroNode2 node6 = new HeroNode2(14, "婊子孙琳");

        // 手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.inThreaded(root);

        // 以编号为10的结点做测试，前驱为3，后继为1
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());

    }
}
