package com.algorithm.luban.day03;

/**
 * @Author 李非凡
 * @Description:
 * 自定义队列
 * 队列是先进先出的集合
 * 队列常用的方法就是入队和出队
 *
 * 队列用数组实现，入队效率高，但是出队效率很低，因为出队需要让数组前移
 * 队列用链表可以用单链表实现，设置两个结点，一个head结点做头结点，一个foot结点做尾结点
 * @Date 2019/4/12 21:10
 * @Version 1.0
 */
public class MyQueue {

    //队列集合中的元素个数（队列的大小）
    int size;

    //头结点（队列的头部）
    Node head;

    //尾结点（队列的尾部）
    Node foot;

    /**
     * 获取队列的大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 入队（向队列中放入元素）
     * @param value
     */
    public void EnQueue(Object value){
        Node newNode = new Node(value);
        //空队列
        if (head == null){
            //头尾结点都等于新结点
            head = foot =newNode;
        }else {
            //在foot后面新加入一个结点
            foot.setNext(newNode);
            //将新加入的结点设置成尾结点（此操作不可放在前面！）
            foot = newNode;
        }
        size++;
    }

    /**
     * 出队（从队列中取出元素）
     * @return
     */
    public Object DeQueue(){
        //取出队列头结点的数据
        Object value = head.getValue();
        //将头结点的下一个结点设置为头结点
        head = head.getNext();
        size--;
        return value;
    }

    /**
     * 查看队列中最前面的元素
     * @return
     */
    public Object peek(){
        return head.getValue();
    }
}
