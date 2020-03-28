package com.atguigu.datastructure.tree.avl;

/**
 * @Author 李非凡
 * @Description: AVL树演示
 * @Date 2020/3/10 23:43
 * @Version 1.0
 */
public class AvlTreeDemo {

    public static void main(String[] args) {
        // 测试左旋数组
        int[] array1 = {4, 3, 6, 5, 7, 8};
        // 测试右旋数组
        int[] array2 = {10, 12, 8, 9, 7, 6};
        // 测试先左后右旋转
        int[] array = {10, 11, 7, 6, 8, 9};
        // 创建一个AvlTree对象
        AvlTree avlTree = new AvlTree();
        for (int value : array) {
            avlTree.add(new Node(value));
        }

        System.out.println("中序遍历");
        avlTree.inOrder();

        System.out.println("AVL树在没有进行平衡处理后：");
        System.out.println("树的高度：" + avlTree.height(avlTree.getRoot()));
        System.out.println("树的左子树的高度：" + avlTree.leftHeight(avlTree.getRoot()));
        System.out.println("树的右子树的高度：" + avlTree.rightHeight(avlTree.getRoot()));
        System.out.println("当前的根结点为：" + avlTree.getRoot());
        System.out.println("当前的根结点的左子结点为：" + avlTree.getRoot().getLeft());
        System.out.println("当前的根结点的右子结点为：" + avlTree.getRoot().getRight());
    }
}
