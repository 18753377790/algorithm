package com.algorithm.interview.boliyuan;


/**
 * @Author 李非凡
 * @Description:
 * 用数组实现一个栈
 * @Date 2019/9/9 23:09
 * @Version 1.0
 */
public class ArrayStack<T> {

    /**
     * 栈的长度
     */
    private int length;

    /**
     * 数组
     */
    private Object[] array;

    /**
     * 栈顶指针（下标）
     */
    private int top;

    /**
     * 构造方法初始化栈
     * @param length
     */
    public ArrayStack(int length){
        // 指定栈的大小
        this.length = length;
        // 默认为-1（空栈）
        top = -1;
        // 数组的长度即为栈的大小
        array = new Object[length];
    }

    /**
     * 栈的大小
     * @return
     */
    public int size(){
        return length;
    }

    /**
     * 指针的位置
     * @return
     */
    public int getTop(){
        return top;
    }

    /**
     * 判断是否为空栈
     * @return
     */
    public boolean isEmpty(){
        return -1 == top;
    }

    /**
     * 判断是否为满栈
     * @return
     */
    public boolean isFull(){
        return length == top - 1;
    }

    /**
     * 入栈
     * @param data
     * @return
     */
    public T push(T data){
        if (isFull()){
            throw new RuntimeException("the stack is full!");
        }
        array[++top] = data;
        return data;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        if (isEmpty()){
            throw new RuntimeException("the stack is empty!");
        }
        return array[top--];
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public Object peek(){
        return array[getTop()];
    }

    /**
     * 遍历栈里的元素
     */
    public void out(){
        for (Object obj : array) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        for (int i = 0; i < stack.size(); i++) {
            stack.push(i);
        }
        stack.out();
        stack.peek();
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
