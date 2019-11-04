package com.algorithm.stack_and_queue;

import java.util.Stack;

/**
 * @Author 李非凡
 * @Description:
 * 两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 栈是后进先出的数据结构，队列是先进先出的数据结构
 * 将数据先压入栈1，然后再将栈1的数据依次出栈，压入栈2，
 * 此时栈2的数据顺序正好是栈1入栈时顺序的反转，因此栈2出栈顺序跟栈1入栈顺序相同
 * @Date 2019/8/13 18:41
 * @Version 1.0
 */
public class TwoStacksImplementQueues {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队
     * @param node 入队的元素
     */
    private void push(int node) {
        stack1.push(node);
    }

    /**
     * 出队
     * @return 出队的元素
     */
    private int pop() {
        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStacksImplementQueues queues = new TwoStacksImplementQueues();
        queues.push(1);
        queues.push(2);
        queues.push(3);
        queues.push(4);
        System.out.println(queues.pop());
        System.out.println(queues.pop());
        System.out.println(queues.pop());
        System.out.println(queues.pop());
    }
}
