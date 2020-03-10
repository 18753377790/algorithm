package com.algorithm.atguigu.stack;

/**
 * @Author 李非凡
 * @Description: 顺序栈，数组实现
 * 定义一个ArrayStack表示栈
 * 思路：
 * 1.使用数组来模拟栈
 * 2.定义一个top来表示栈顶，初始化为-1
 * 3.入栈的操作，当有数据加入到栈时，top++，stack[top] = data
 * 4.出栈的操作，int value = stack[top]，top--，return value
 * @Date 2020/3/3 17:11
 * @Version 1.0
 */
public class ArrayStack2 {

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组模拟栈，数据放在该数组中
     */
    private int[] stack;

    /**
     * top表示栈顶，初始化为-1
     */
    private int top = -1;

    /**
     * 构造器，初始化栈
     * @param maxSize
     */
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断栈满的方法
     * @return
     */
    public boolean isFull() {
        // 数组下标从0开始，所以栈满的标志是array.length - 1
        return top == maxSize - 1;
    }

    /**
     * 判断栈空的方法
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈push
     * @param value
     */
    public void push(int value) {
        // 先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈pop，将栈顶的数据返回
     * @return
     */
    public int pop() {
        // 先判断栈是否空
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 查看栈顶元素
     * 可以返回当前栈顶的值，但不是真正的pop
     * @return 栈顶元素
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 显示栈的情况（遍历栈），遍历时需要从栈顶开始显示数据
     */
    public void list() {
        // 先判断栈是否空
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        // 遍历时需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }


    /**
     * 返回运算符的优先级，优先级是程序员来确定，优先级用数字表示
     * 数字越大，则优先级就越高。
     * @param operator
     * @return
     */
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        }else if (operator == '+' || operator == '-') {
            return 0;
        }else {
            // 假定目前的表达式只有+，-，*，/四种运算符
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     * @param operator
     * @return
     */
    public boolean isOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    /**
     * 计算方法
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
    public int calculate(int num1, int num2, int operator) {
        // 用于存放计算的结果
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                // 注意顺序
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}
