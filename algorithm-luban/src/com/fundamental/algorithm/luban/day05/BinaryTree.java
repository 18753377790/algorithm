package com.fundamental.algorithm.luban.day05;

/**
 * @Author 李非凡
 * @Description:
 * 自定义二叉树（顺序二叉树，用链表实现二叉树）
 * 二叉树是一种特殊的树，每个节点下面至多能有2个结点，2个结点称为左右儿子
 * 链表实现二叉树最重要的是二叉树的根节点
 *
 * 左小右大：顺序二叉树
 * 比较时要先从根节点开始比较，逐层比较，小的放左边，大的（或者相等）放右边
 * 两数相比之分小于/非小于，大于/非大于
 *
 * 二叉树的遍历
 * 前序遍历：打印顺序中左右
 * 中序遍历：打印顺序左中右（顺序二叉树使用中序遍历会是一个有序的数：中序排序算法）
 * 后序遍历：打印顺序左右中
 * @Date 2019/4/14 1:52
 * @Version 1.0
 */
public class BinaryTree {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 向二叉树中添加元素
     * @param value 待添加的元素值
     */
    public void add(int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
        }else {
            // temp表示当前节点
            Node temp = root;
            // 因为不知道二叉树有几层，所以采用死循环
            while (true){
                // 小的在左边
                if (value < temp.getValue()){
                    // 如果左边没节点，可以把此节点设置为左节点
                    if (temp.getLeft() == null){
                        temp.setLeft(newNode);
                        break;
                    }else{
                        temp = temp.getLeft();
                    }
                }else{
                    // 大的（等于的）在右边
                    if (temp.getRight() == null){
                        temp.setRight(newNode);
                        break;
                    }else {
                        temp = temp.getRight();
                    }
                }
            }
        }
    }

    /**
     * 显示二叉树
     */
    public void show(){
        showNode(root);
    }

    /**
     * 递归遍历二叉树（顺序二叉树）
     * 输出语句只能同时存在一条，要么是前序遍历，要么是中序遍历，要么是后序遍历
     * @param node 结点
     */
    private void showNode(Node node){
        // 前序遍历
        System.out.println(node.getValue());
        // 向左走
        if (node.getLeft() != null)
            showNode(node.getLeft());
        // 中序遍历
//        System.out.println(node.getValue());
        // 向右走
        if (node.getRight() != null)
            showNode(node.getRight());
        // 后序遍历
//        System.out.println(node.getValue());
    }
}
