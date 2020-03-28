package com.atguigu.datastructure.tree;

/**
 * @Author 李非凡
 * @Description: 英雄结点（用于线索化二叉树）
 * @Date 2020/3/9 12:49
 * @Version 1.0
 */
public class HeroNode2 {

    /**
     * 编号
     */
    private int no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 左子结点，默认为null
     */
    private HeroNode2 left;

    /**
     * 右子结点，默认为null
     */
    private HeroNode2 right;

    /**
     * 如果leftType为0表示指向的是左子树，如果为1表示指向前驱结点
     */
    private int leftType;

    /**
     * 如果rightType为0表示指向的是右子树，如果为1表示指向后继结点
     */
    private int rightType;

    /**
     * 为了实现线索化，需要创建指向当前结点的前驱结点的指针
     * 在递归进行线索化时，pre总是保留前一个结点
     */
    private HeroNode2 pre;

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
