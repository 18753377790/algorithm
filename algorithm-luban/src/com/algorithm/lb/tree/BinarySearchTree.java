package com.algorithm.lb.tree;

/**
 * @Author 李非凡
 * @Description:
 * 二叉搜索树（二叉查找树，二叉排序树）->平衡树->AVL树/红黑树
 * 原理有点像二分查找，二叉搜索树的中序遍历是有序的
 * 1.如果它的左子树不为空，则左子树上结点的值都小于根结点。
 * 2.如果它的右子树不为空，则右子树上结点的值都大于根结点。
 * 3.子树同样也要遵循以上两点
 *
 * 二叉查找树查找的时间复杂度为logn，查找的时间复杂度其实就是树的深度
 * 2^3 = 8
 * 2^10 = 1024
 * 2^32 = 21亿 Integer.MAX_VALUE
 *
 * 由于，二叉搜索树的根节点可能是数据中最小的那个，所以出现了平衡树（AVL树和红黑树）
 * AVL树（绝对的平衡二叉树）：
 * 平衡二叉树，它的左右子树高度之差不超过1
 * 这样确实可以避免一条直线型的结构，但还不是我们最理想的。
 * 因为插入删除开销太大。
 *
 * 通过性能综合考虑选用：
 * 红黑树（近似的平衡二叉树）：
 * 1.每个结点不是红色就是黑色
 * 2.不可能有连在一起的红色结点
 * 3.根结点都是黑色
 * 4.每个红色结点的两个子结点都是黑色。
 * 5.任一结点到其子树中每个叶子节点的路径都有相同数量
 * 的黑色结点。
 *
 * 改变颜色：根结点
 * 左旋：逆时针旋转
 * 右旋：顺时针旋转
 *
 * 红黑树的应用：
 * HashMap
 * TreeMap->TreeSet
 * Windows文件搜索
 *
 * MySQL索引不用红黑树的原因：
 * 因为磁盘IO问题，红黑树浪费磁盘空间，磁盘存储取数据会取出很多东西，造成浪费
 * @Date 2019/9/17 22:59
 * @Version 1.0
 */
public class BinarySearchTree {

    private int data;

    private BinarySearchTree left;

    private BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(){

    }

    public void find(){

    }

    /**
     * 先根遍历
     */
    public void preOrder(){

    }

    /**
     * 中根遍历
     */
    public void inOrder(){

    }

    /**
     * 后根遍历
     */
    public void postOrder(){

    }

    public static void main(String[] args) {
        int[] data = {0,5,9,1,2,3,10};
        String s1 = null;
        String s2 = "abc";
        System.out.println(s1+s2);
    }
}

/**
 * 二叉搜索树结点类
 */
class BSTNode{

    /**
     * 结点的数据
     */
    private int data;

    /**
     * 结节点
     */
    private BSTNode leftNode;

    /**
     * 结节点
     */
    private BSTNode rightNode;

    public BSTNode(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
}
