package com.fundamental.algorithm.luban.day03;

/**
 * @Author 李非凡
 * @Description:
 * 自定义栈和自定义队列测试类
 * @Date 2019/4/13 16:47
 * @Version 1.0
 */
public class StackAndQueueTest {

    public static void main(String[] args) {
        //栈：先进后出
        MyStack stack = new MyStack();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //将栈中数据取出
        while (stack.getSize() > 0){
            System.out.println(stack.pop());
        }

        //队列：先进先出
        MyQueue queue = new MyQueue();
        queue.EnQueue(2);
        queue.EnQueue(3);
        queue.EnQueue(4);
        queue.EnQueue(5);
        //将队列中数据取出
        while (queue.getSize() > 0){
            System.out.println(queue.DeQueue());
        }
    }
}
