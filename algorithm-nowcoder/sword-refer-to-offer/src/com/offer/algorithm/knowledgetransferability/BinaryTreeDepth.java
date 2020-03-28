package com.offer.algorithm.knowledgetransferability;

/**
 * @Author 李非凡
 * @Description:
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @Date 2019/8/20 21:47
 * @Version 1.0
 */
public class BinaryTreeDepth {

    /**
     * 二叉树深度
     * 如果该树只有一个结点，它的深度为1.如果根节点只有左子树没有右子树，那么树的深度为左子树的深度加1；
     * 同样，如果只有右子树没有左子树，那么树的深度为右子树的深度加1。如果既有左子树也有右子树，那该树的深度就是左子树和右子树的最大值加1.
     * @param root 二叉树的结点
     * @return 二叉树的深度
     */
    private int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}