package com.atguigu.datastructure.tree.avl;

/**
 * @Author 李非凡
 * @Description: 平衡二叉搜索树（Self-balancing binary search tree）
 * 平衡二叉树基本介绍：
 * 1.平衡二叉树也叫平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树， 可以保证查询效率较高。
 * 2.具有以下特点：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 平衡二叉树的常用实现方法有红黑树、AVL(AVL算法)、替罪羊树、Treap、伸展树等。
 *
 * 平衡二叉搜索树的旋转
 * 1.左旋：当前结点的右子树高度大于左子树（rightHeight - leftHeight > 1）时，进行左旋，降低右子树的高度，增加左子树的高度
 * 2.右旋：当前结点的左子树高度大于右子树（leftHeight - rightHeight > 1）时，进行右旋，降低左子树的高度，增加右子树的高度
 * 3.双向旋转（先左后右）：
 *   当前结点符合右旋条件时，如果它的左子树的右子树高度大于它的左子树的左子树高度
 *   先对当前结点的左结点（左子树）进行左旋，再对当前结点进行右旋
 * 4.双向旋转（先右后左）：
 *   当前结点符合左旋条件时，如果它的右子树的左子树高度大于它的右子树的右子树高度
 *   先对当前结点的右结点（右子树）进行右旋，再对当前结点进行左旋
 * @Date 2020/3/10 23:43
 * @Version 1.0
 */
public class AvlTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 返回当前结点的高度，即以该结点为根结点的树的高度
     * @param root
     * @return
     */
    public int height(Node root) {
        return Math.max(root.getLeft() == null ? 0 : height(root.getLeft()),
                root.getRight() == null ? 0 : height(root.getRight())) + 1;
    }

    /**
     * 返回左子树的高度
     * @param root
     * @return
     */
    public int leftHeight(Node root) {
        if (root.getLeft() == null) {
            return 0;
        }
        return height(root.getLeft());
    }

    /**
     * 返回右子树的高度
     * @param root
     * @return
     */
    public int rightHeight(Node root) {
        if (root.getRight() == null) {
            return 0;
        }
        return height(root.getRight());
    }

    /**
     * 左旋转 LR
     * @param root
     */
    private void leftRotation(Node root) {
        // 以当前根结点的值创建新的结点
        Node newNode = new Node(root.getValue());
        // 把新的结点newNode的左子树设置成当前结点的左子树
        newNode.setLeft(root.getLeft());
        // 把新的结点newNode的右子树设置成当前结点的右子树的左子树
        newNode.setRight(root.getRight().getLeft());
        // 把当前结点值替换成右子结点的值
        root.setValue(root.getRight().getValue());
        // 把当前结点的右子树设置成当前结点的右子树的右子树
        root.setRight(root.getRight().getRight());
        // 把当前结点的左子结点设置成新的结点
        root.setLeft(newNode);
    }

    /**
     * 右旋转 RR
     * @param root
     */
    private void rightRotation(Node root) {
        // 以当前根结点的值创建新的结点
        Node newNode = new Node(root.getValue());
        // 把新的结点newNode的右子树设置成当前结点的右子树
        newNode.setRight(root.getRight());
        //
        newNode.setLeft(root.getLeft().getRight());
        //
        root.setValue(root.getLeft().getValue());
        //
        root.setLeft(root.getLeft().getLeft());
        //
        root.setRight(newNode);
    }

    /**
     * 添加结点
     * @param node 要添加的结点
     */
    public void add(Node node) {
        // 如果root为空，则直接让root指向node
        if (this.root == null) {
            this.root = node;
        }else {
            this.add(this.root, node);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (this.root != null) {
            this.inOrder(this.root);
        }else {
            System.out.println("二叉排序树为空");
        }
    }

    /**
     * 查找要删除的结点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.root == null) {
            return null;
        }else {
            return this.search(this.root, value);
        }
    }

    /**
     * 查找要删除的结点的父结点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (this.root == null) {
            return null;
        }else {
            return this.searchParent(this.root, value);
        }
    }

    /**
     * 添加结点
     * 递归的形式添加结点
     * 注意：要满足二叉排序树的要求
     * @param root 根结点
     * @param node 要添加的结点
     */
    public void add(Node root, Node node) {
        // 如果结点为空，直接return
        if (node == null) {
            return;
        }

        // 判断传入的结点的值和当前子树的根结点的值的关系
        if (node.getValue() < root.getValue()) {
            // 如果当前结点左子结点为空
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else {
                // 递归的向左子树添加
                add(root.getLeft(), node);
            }
        } else {
            /*
             添加的结点的值大于等于当前结点的值
             如果当前结点右子结点为空
             */
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                // 递归的向右子树添加
                add(root.getRight(), node);
            }
        }

        // 当添加完一个结点后，如果（rightHeight - leftHeight > 1），进行左旋转
        if (rightHeight(root) - leftHeight(root) > 1) {
            // 当前结点符合左旋条件时，如果它的右子树的左子树高度大于它的右子树的右子树高度
            if (root.getRight() != null && leftHeight(root.getRight()) > rightHeight(root.getRight())) {
                // 先对当前结点的右结点（右子树）进行右旋
                rightRotation(root.getRight());
            }
            // 直接进行左旋
            leftRotation(root);
            // 必须加return或者使用if else if
            return;
        }

        // 当添加完一个结点后，如果（leftHeight - rightHeight > 1），进行右旋转
        if (leftHeight(root) - rightHeight(root) > 1) {
            // 当前结点符合右旋条件时，如果它的左子树的右子树高度大于它的左子树的左子树高度
            if (root.getLeft() != null && rightHeight(root.getLeft()) > leftHeight(root.getLeft())) {
                // 先对当前结点的左结点（左子树）进行左旋
                leftRotation(root.getLeft());
            }
            // 直接进行右旋
            rightRotation(root);
        }
    }

    /**
     * 中序遍历
     * @param root 根结点
     */
    public void inOrder(Node root) {
        if (root.getLeft() != null) {
            inOrder(root.getLeft());
        }
        System.out.println(root);
        if (root.getRight() != null) {
            inOrder(root.getRight());
        }
    }

    /**
     * 查找要删除的结点
     * @param root 根结点
     * @param value 希望删除的结点的值
     * @return 如果找到则返回该结点，否则返回null
     */
    public Node search(Node root, int value) {
        if (value == root.getValue()) {
            return root;
        }else if (value < root.getValue()) {
            // 如果查找值小于当前结点，向左子树递归查找
            if (root.getLeft() == null) {
                // 如果左子结点为空，直接返回null
                return null;
            }else {
                return search(root.getLeft(), value);
            }
        }else {
            // 如果查找值大于等于当前结点，向右子树递归查找
            if (root.getRight() == null) {
                // 如果右子结点为空，直接返回null
                return null;
            }else {
                return search(root.getRight(), value);
            }
        }
    }

    /**
     * 查找要删除的结点的父结点
     * @param root
     * @param value
     * @return
     */
    public Node searchParent(Node root, int value) {

        boolean left = false;
        boolean right = false;

        if (root.getLeft() != null) {
            left = root.getLeft().getValue() == value;
        }

        if (root.getRight() != null) {
            right = root.getRight().getValue() == value;
        }

        /*
         if ((root.getLeft() != null && root.getLeft().getValue() == value) || (root.getRight() != null && root.getRight().getValue() == value))
         如果当前结点就是要删除的结点的父结点，就返回
         */
        if (left || right) {
            return root;
        }else {
            /*
             如果当前结点不是要删除结点的父结点，则向当前结点的左右子树查询
             如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
             */
            if (value < root.getValue() && root.getLeft() != null){
                // 向左子树递归查找
                return searchParent(root.getLeft(), value);
            }else if (value >= root.getValue() && root.getRight() != null) {
                // 向右子树递归查找
                return searchParent(root.getRight(), value);
            }else {
                // 没有找到父结点
                return null;
            }
        }
    }

    /**
     * 从右子树找到最小的
     * 返回以node为根结点的二叉排序树的最小结点的值
     * 删除以node为根结点的二叉排序树的最小结点
     * @param node
     * @return
     */
    public int deleteMinNode(Node node) {
        Node target = node;
        // 循环的查找左结点，就会找到最小值
        while (target.getLeft() != null) {
            target = target.getLeft();
        }
        // 这时target就指向了最小结点，删除最小结点
        delete(target.getValue());
        return target.getValue();
    }

    /**
     * 思考题：从左子树找到最大的
     * 返回以node为根结点的二叉排序树的最大结点的值
     * 删除以node为根结点的二叉排序树的最大结点
     * @param node
     * @return
     */
    public int deleteMaxNode(Node node) {
        Node target = node;
        // 循环的查找右结点，就会找到最大值
        while (target.getRight() != null) {
            target = target.getRight();
        }
        // 这时target就指向了最大结点，删除最大结点
        delete(target.getValue());
        return target.getValue();
    }

    /**
     * 删除结点
     * @param value
     */
    public void delete(int value) {
        if (root == null) {
            System.out.println();
        }else {
            // 先去找到要删除的结点target
            Node target = search(value);
            // 如果没有找到要删除的结点
            if (target == null) {
                return;
            }
            //
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }
            // 去找到target的父结点
            Node parent = searchParent(value);
            // 如果要删除的结点是叶子结点
            if (target.getLeft() == null && target.getRight() == null) {
                // 判断target是父结点的左子结点还是右子结点
                if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                    // 是左子结点
                    parent.setLeft(null);
                }else if (parent.getRight() != null && parent.getRight().getValue() == value) {
                    // 是右子结点
                    parent.setRight(null);
                }
            }else if (target.getLeft() != null && target.getRight() != null) {
                // 删除两颗子树的结点
                int minValue = deleteMinNode(target.getRight());
                target.setValue(minValue);
            }else {// 删除一颗子树的结点
                // 如果target有左子结点
                if (target.getLeft() != null) {
                    if (parent != null) {
                        // 如果target是parent的左子结点
                        if (parent.getLeft().getValue() == value) {
                            parent.setLeft(target.getLeft());
                        }else {
                            // 如果target是parent的右子结点
                            parent.setRight(target.getLeft());
                        }
                    }else {
                        root = target.getLeft();
                    }
                }else {
                    // 如果target有右子结点
                    if (parent != null) {
                        // 如果target是parent的左子结点
                        if (parent.getLeft().getValue() == value) {
                            parent.setLeft(target.getRight());
                        }else {
                            // 如果target是parent的右子结点
                            parent.setRight(target.getRight());
                        }
                    }else {
                        root = target.getRight();
                    }
                }
            }
        }
    }
}
