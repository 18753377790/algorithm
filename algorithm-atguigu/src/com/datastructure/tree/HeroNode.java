package com.datastructure.tree;

/**
 * @Author 李非凡
 * @Description: 英雄结点（用于实现二叉树）
 * @Date 2020/3/8 10:38
 * @Version 1.0
 */
public class HeroNode {

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
    private HeroNode left;

    /**
     * 右子结点，默认为null
     */
    private HeroNode right;

    public HeroNode(int no, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
