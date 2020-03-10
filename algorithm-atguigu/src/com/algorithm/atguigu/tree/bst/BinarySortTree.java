package com.algorithm.atguigu.tree.bst;

/**
 * @Author 李非凡
 * @Description: 二叉排序树（BinarySortTree）
 * 二叉排序树：BST（BinarySort(Search)Tree）
 * 特别说明：如果有相同的值，可以将该结点放在左子结点或右子结点
 *
 * 二叉排序树的删除：
 * 1.删除叶子结点
 *   1.1先去找到要删除的结点target
 *   1.2找到target的父结点parent（考虑是否存在父结点）
 *   1.3确定target是parent的左子结点还是右子结点
 *   1.4根据前面的情况来对应删除：
 *      如果是左子结点：parent.setLeft(null)
 *      如果是右子结点：parent.setRight(null)
 * 2.删除只有一颗子树的结点
 *    2.1先去找到要删除的结点target
 *    2.2找到target的父结点parent（考虑是否存在父结点）
 *    2.3确定target的子结点是左子结点还是右子结点
 *    2.4确定target是parent的左子结点还是右子结点
 *    2.5如果target有左子结点
 *       如果target是parent的左子结点：parent.setLeft(target.getLeft())
 *       如果target是parent的右子结点：parent.setRight(target.getLeft())
 *    2.6如果target有右子结点
 *       如果target是parent的左子结点：parent.setLeft(target.getRight())
 *  *    如果target是parent的右子结点：parent.setRight(target.getRight())
 * 3.删除有两颗子树的结点
 *   3.1先去找到要删除的结点target
 *   3.2找到target的父结点parent（考虑是否存在父结点）
 *   3.3从target的右子树找到最小的结点（或者左子树找到最大的结点）
 *   3.4用一个临时变量将最小的结点的值保存
 *   3.5删除该最小结点
 *   3.6target.setValue(temp.getValue())
 * @Date 2020/3/10 3:02
 * @Version 1.0
 */
public class BinarySortTree {

    /**
     * 根结点
     */
    private Node root;

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
                    // 如果target是parent的左子结点
                    if (parent.getLeft().getValue() == value) {
                        parent.setLeft(target.getLeft());
                    }else {
                        // 如果target是parent的右子结点
                        parent.setRight(target.getLeft());
                    }
                }else {// 如果target有右子结点
                    // 如果target是parent的左子结点
                    if (parent.getLeft().getValue() == value) {
                        parent.setLeft(target.getRight());
                    }else {
                        // 如果target是parent的右子结点
                        parent.setRight(target.getRight());
                    }
                }
            }
        }
    }
 }
