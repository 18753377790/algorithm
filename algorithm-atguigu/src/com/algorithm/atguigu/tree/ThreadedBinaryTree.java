package com.algorithm.atguigu.tree;

/**
 * @Author 李非凡
 * @Description: 线索化二叉树（实现了线索化功能的二叉树）
 * @Date 2020/3/9 3:44
 * @Version 1.0
 */
public class ThreadedBinaryTree {

    /**
     * 中序线索化
     * 1.先线索化左子树
     * 2.线索化当前结点
     * 3.再线索化右子树
     * @param root 当前需要线索化的结点（初始为根结点）
     */
    public void inThreaded(HeroNode2 root) {
        // 如果当前结点为空(node == null)，不能线索化
        if (root == null) {
            return;
        }
        // 1.先线索化左子树
        inThreaded(root.getLeft());

        HeroNode2 pre = root.getPre();

        /*
         2.线索化当前结点
         处理当前结点的前驱结点
         以第一个结点为例
         第一个结点的left==nul，且leftType==1
         */
        if (root.getLeft() == null) {
            // 让当前结点的左指针指向前驱结点
            root.setLeft(pre);
            // 修改当前结点的左指针的类型，指向前驱结点
            root.setLeftType(1);
        }

        // 处理当前结点的后继结点
        if (pre != null && pre.getRight() == null) {
            // 让前驱结点的右指针指向当前结点
            pre.setRight(root);
            // 修改前驱结点的右指针类型
            pre.setRightType(1);
        }

        // 注意：每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = root;

        // 3.再线索化右子树
        inThreaded(root.getRight());
    }
}
