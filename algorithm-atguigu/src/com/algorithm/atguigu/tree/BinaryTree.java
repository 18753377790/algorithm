package com.algorithm.atguigu.tree;

/**
 * @Author 李非凡
 * @Description: 二叉树
 * 树存储方式的分析：能提高数据存取，读取的效率
 *
 * 树的常用术语
 * 1.结点
 * 2.根结点
 * 3.父结点
 * 4.子结点
 * 5.叶子结点：没有子结点的结点
 * 6.结点的权
 * 7.路径：从根结点到该结点的路线
 * 8.层
 * 9.子树
 * 10.树的高度，深度
 * 11.深林：多颗子树构成深林
 *
 * 满二叉树结点总数为2^n - 1 n为层数
 *
 * 前序遍历：根左右
 * 中序遍历：左根右
 * 后序遍历：左右根
 * 总结：看父（根）结点输出的顺序确定前中后遍历
 *
 * 二叉树前中后遍历步骤
 * 1.创建一颗二叉树
 * 2.前序遍历
 *   2.1先输出当前结点（初始的时候是根结点）
 *   2.2如果左子结点不为空，则递归继续前序遍历
 *   2.3如果右子结点不为空，则递归继续前序遍历
 * 3.中序遍历
 *   3.1如果当前结点的左子结点不为空，则递归继续中序遍历
 *   3.2输出当前结点
 *   3.3如果当前结点的右子结点不为空，则递归继续中序遍历
 * 4.后序遍历
 *   4.1如果当前结点的左子结点不为空，则递归继续后序遍历
 *   4.2如果当前结点的右子结点不为空，则递归继续后序遍历
 *   4.3输出当前结点
 *
 * 二叉树前中后序查找
 * 前序查找：根左右
 * 中序查找：左根右
 * 后序查找：左右根
 * @Date 2020/3/8 10:38
 * @Version 1.0
 */
public class BinaryTree {

    /**
     * 根结点
     */
    private HeroNode root;

    /**
     * 前序遍历
     * @param root 根结点
     */
    public void preOrder(HeroNode root) {
        if (root != null) {
            // 先输出父结点
            System.out.println(root);
            // 递归向左子树前序遍历
            if (root.getLeft() != null) {
                preOrder(root.getLeft());
            }
            // 递归向右子树前序遍历
            if (root.getRight() != null) {
                preOrder(root.getRight());
            }
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     * @param root 根结点
     */
    public void inOrder(HeroNode root) {
        if (root != null) {
            // 递归向左子树中序遍历
            if (root.getLeft() != null) {
                inOrder(root.getLeft());
            }
            // 输出父结点
            System.out.println(root);
            // 递归向右子树中序遍历
            if (root.getRight() != null) {
                inOrder(root.getRight());
            }
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历
     * @param root 根结点
     */
    public void postOrder(HeroNode root) {
        if (root != null) {
            // 递归向左子树中序遍历
            if (root.getLeft() != null) {
                postOrder(root.getLeft());
            }
            // 递归向右子树中序遍历
            if (root.getRight() != null) {
                postOrder(root.getRight());
            }
            // 输出父结点
            System.out.println(root);
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    /**
     * 前序查找
     * 1.先判断当前结点是否为要查找结点
     * 2.如果相等，就返回当前结点
     * 3.如果不等，则判断当前结点的左子结点是否为空，如果不为空，则递归前序查找
     * 4.如果左递归前序查找找到了结点，则返回，否则继续判断当前结点的右子结点是否为空，
     *   如果不为空，则继续向右递归前序查找
     * @param root 根结点
     * @param no 要查找的结点的编号
     * @return 如果找到就返回该Node，如果没有找到就返回null
     */
    public HeroNode preOrderSearch(HeroNode root, int no) {


        if (root != null) {
            System.out.println("进入前序查找");
            // 比较当前结点是不是
            if (root.getNo() == no) {
                return root;
            }

            HeroNode resultNode = null;

            if (root.getLeft() != null) {
                resultNode = preOrderSearch(root.getLeft(), no);
            }
            // 说明在左子树找到
            if (resultNode != null) {
                return resultNode;
            }

            if (root.getRight() != null) {
                resultNode = preOrderSearch(root.getRight(), no);
            }
            // 在右子树找没找到都要返回
            return resultNode;
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     *  中序查找
     *  1.先判断当前结点的左子结点是否为空，如果不为空，则递归中序查找
     *  2.如果找到，则返回，如果没有找到就和当前结点比较，如果是则返回当前结点，否则继续进行右递归的中序查找
     *  3.如果右递归中序查找，就返回，否则返回空
     * @param root 根结点
     * @param no 要查找的结点的编号
     * @return 如果找到就返回该Node，如果没有找到就返回null
     */
    public HeroNode inOrderSearch(HeroNode root, int no) {


        if (root != null) {
            HeroNode resultNode = null;

            if (root.getLeft() != null) {
                resultNode = inOrderSearch(root.getLeft(), no);
            }

            // 说明在左子树找到
            if (resultNode != null) {
                return resultNode;
            }
            System.out.println("进入中序查找");
            // 比较当前结点是不是
            if (root.getNo() == no) {
                return root;
            }

            if (root.getRight() != null) {
                resultNode = inOrderSearch(root.getRight(), no);
            }

            return resultNode;
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * 后序查找
     * 1.先判断当前结点的左子结点是否为空，如果不为空，则递归后序查找
     * 2.如果找到，就返回，如果没有找到就判断当前结点的右子结点是否为空，
     *   如果不为空，则右递归进行后续查找，如果找到，就返回
     * 3.如果没有找到，就和当前结点进行比较，如果是则返回，否则返回空
     * @param root 根结点
     * @param no 要查找的结点的编号
     * @return 如果找到就返回该Node，如果没有找到就返回null
     */
    public HeroNode postOrderSearch(HeroNode root, int no) {

        if (root != null) {
            HeroNode resultNode = null;

            if (root.getLeft() != null) {
                resultNode = postOrderSearch(root.getLeft(), no);
            }

            // 说明在左子树找到
            if (resultNode != null) {
                return resultNode;
            }

            if (root.getRight() != null) {
                resultNode = postOrderSearch(root.getRight(), no);
            }
            // 说明在右子树找到
            if (resultNode != null) {
                return resultNode;
            }
            System.out.println("进入后序查找");
            // 比较当前结点是不是
            if (root.getNo() == no) {
                return root;
            }
            return resultNode;
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * 二叉树递归删除结点
     * 1.如果删除的是叶子结点，则删除该结点
     * 2.如果删除的是非叶子结点，则删除该子树
     *
     * 思路：
     * 1.如果此二叉树是空树或者只有一个根结点root，则将二叉树置空
     * 2.因为此二叉树是单向的，所以只能判断当前结点的子结点是不是待删除的结点，而不能判断当前结点是不是待删除的结点
     * 3.如果当前结点的左子结点不为空并且左子结点就是待删除的结点，就将其左子结点置空并且返回（结束递归）
     * 4.如果当前结点的右子结点不为空并且右子结点就是待删除的结点，就将其右子结点置空并且返回（结束递归）
     * 5.如果第2,3步都没有删除结点，则向左子树进行递归删除
     * 6.如果第4步没有删除结点，则向右子树进行递归删除
     * @param root 根结点
     * @param no 待删除结点的编号
     */
    public void delete(HeroNode root, int no) {

        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            }else {
                if (root.getLeft() != null && root.getLeft().getNo() == no) {
                    root.setLeft(null);
                    return;
                }

                if (root.getRight() != null && root.getRight().getNo() == no) {
                    root.setRight(null);
                    return;
                }

                if (root.getLeft() != null) {
                    delete(root.getLeft(), no);
                }

                if (root.getLeft() != null) {
                    delete(root.getRight(), no);
                }
            }
        }else {
            System.out.println("空树不能删除");
        }
    }

    /**
     * 删除结点
     * 思考题：
     * 如果要删除的结点是非叶子结点，不要删除以该叶子结点为根结点的子树
     * 规则：
     * 1.如果该非叶子结点只有一个子结点，则让该子结点替代该结点
     * 2.如果该非叶子结点有两个子结点，则让该结点的左子结点替代该结点
     *
     * 二叉搜索树的删除操作中会遇到此问题
     * @param root 根结点
     * @param no 待删除结点的编号
     */
    public void deletePlus(HeroNode root, int no) {

    }
}
