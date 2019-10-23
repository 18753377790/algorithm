package com.algorithm.luban.day02;

/**
 * @Author 李非凡
 * @Description:
 * 自定义链表
 * LinkedList底层是用双向循环链表进行实现的
 *
 * 链表的组成元素是结点(node)，每个结点存有数据和下一个结点的地址，是链式存储
 * 单链表：本自定义链表就是单链表
 * 单向循环链表：最后一个结点的地址指向头结点
 * 双链表：存储上一个结点的地址，值和下一个结点的地址
 * 双向循环链表：头结点的上一个结点的地址指向最后一个结点，最后一个结点的下一个结点的地址指向头结点
 *
 * 添加数据：LinkedList只需要根据头结点找到最后一个新增的结点，然后改变头结点和原来最后一个结点的地址就可以，效率高
 * 删除数据：LinkedList删除数据删除前面的数据和删除后面的数据效率都高，中间的数据效率低，但是最慢用时是ArrayList的50%
 * 遍历数据：LinkedList遍历数据的效率非常低，因为外面进行循环遍历，方法里面还是要进行循环遍历
 * 获取（查找）或设置数据：LinkedList获取（查找）或设置数据，还需要在内部方法去循环才能操作，效率较低
 * @Date 2019/4/7 20:53
 * @Version 1.0
 */
public class MyLinkedList {

    //供外部外部看到的大小，这里使用了障眼法
    private int size;

    //表示头结点，链表的头结点最重要，找到了头结点就能找到下面的结点
    private Node head = null;

    /**
     * 返回集合大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 向集合中添加元素
     * @param value
     */
    public void add(Object value){
        Node newNode = new Node(value);
        //添加的第一个结点
        if (head == null){
            head = newNode;
        }else {
            //使用temp来表示当前结点，当前结点从头结点开始
            Node temp = head;
            //表示temp后面还有（通过结点一步一步的找到最后一个结点）
            while (temp.getNext() != null){
                //让当前结点向后移动（这个操作就是将指针不停的往后移动，直到最后一个结点）
                temp = temp.getNext();
            }
            //循环结束时，temp表示最后一个结点（此时，temp后面没有结点，在temp后面新增一个结点并将新添加的数据放入里面）
            temp.setNext(newNode);
        }
        size++;
    }

    /**
     * 根据索引返回集合中的元素
     * @param index
     * @return
     */
    public Object get(int index){
        Node temp = head;
        //当index为0时，获取的是头结点的数据，此时循环不执行
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    /**
     * 根据索引设置集合中的元素
     * @param index
     * @param value
     */
    public void set(int index, Object value){
        Node temp = head;
        //当index为0时，获取的是头结点的数据，此时循环不执行
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.setValue(value);
    }

    /**
     * 清除集合中所有的元素
     */
    public void clear(){
        size = 0;
        //头结点一旦为空，剩余结点的数据也会被垃圾回收器回收
        head = null;
    }

    /**
     * 根据索引删除集合中的元素
     * @param index
     */
    public void removeAt(int index){
        if (index == 0){
            //删除头元素：让头指向头的下一个（此时，头结点为第二个节点，原头结点会被回收）
            head = head.getNext();
        }else {
            //循环找到删除元素的前一个元素
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.getNext();
            }
            /*
            循环结束，temp表示index前面位置的元素
            设置当前元素的下一个元素是：当前元素的下一个的下一个
             */
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }
}
