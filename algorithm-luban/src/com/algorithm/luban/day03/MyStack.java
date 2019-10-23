package com.algorithm.luban.day03;

/**
 * @Author 李非凡
 * @Description:
 * 自定义栈
 * 栈是先进后出（后进先出）的集合
 * 栈常用的方法只有入栈和出栈，没有添加和删除，入栈无法人为决定位置，只能一个一个入栈，出栈也是必须按顺序来
 *
 * 栈用数组实现，因为是只从数组的末尾进行操作，所以入栈（添加）和出栈（删除）效率高
 * 栈用链表实现，效率一样很高
 * @Date 2019/4/12 21:10
 * @Version 1.0
 */
public class MyStack {

    /**
     * 栈集合的元素个数（栈的大小）
     */
    private int size;

    /**
     * 表示头元素（头结点）
     */
    private Node head = null;

    /**
     * 获取栈的大小
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 入栈（压入，将元素放入到栈中）
     * @param value
     */
    public void push(Object value){
        Node newNode = new Node(value);
        //head为空
        if (head == null){
            head = newNode;
        }else { //head不为空（栈顶的结点是结节点，栈底的结点是链表的最后一个结点）
            //新结点的下一个结点是头结点
            newNode.setNext(head);
            //头结点指向新结点（此操作不可放在前面！）
            head = newNode;
        }
        size++;
    }

    /**
     * 出栈（弹出，将元素从栈中取出）
     * @return
     */
    public Object pop(){
        //先取出头结点的值
        Object value = head.getValue();
        //将原头结点的下一个结点设置为头结点，即为将头结点指向下一个结点（此操作不可放在前面！）
        head = head.getNext();
        size--;
        return value;
    }

    /**
     * 查看，只查看栈顶的元素（链表的size不会改变）
     * @return
     */
    public Object peek(){
        return head.getValue();
    }
}
